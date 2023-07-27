package loosecoupling.lc;

import loosecoupling.collector.EMailMetadataCollector;
import loosecoupling.collector.MetadataCollector;
import loosecoupling.collector.SMSMetadataCollector;
import loosecoupling.export.EMAILExport;
import loosecoupling.export.ExportMetadata;
import loosecoupling.export.SMSExport;
import loosecoupling.fetch.EMAILFetch;
import loosecoupling.fetch.FetchMetadata;
import loosecoupling.fetch.SMSFetch;

import java.util.Scanner;

public class MessageProgram {

	public static void setMetadataCollector(MetadataCollector mdcollector,
                                            FetchMetadata fetchMetadata,
                                            ExportMetadata exportMetadata) {
		mdcollector.setMetadataCollector(fetchMetadata, exportMetadata);
	}
	
	public static void collectMetadata(MetadataCollector mdcollector) {
		mdcollector.collectMetadata();
	}
	private MetadataCollector messagingService;

	// 메시징 서비스를 설정하는 메서드
	public void setMessagingService(MetadataCollector messagingService) {
		this.messagingService = messagingService;
	}

	// 이메일 주소 유효성 체크 메서드
	private boolean isValidEmail(String email) {
		// 정규 표현식을 사용하여 이메일 주소의 유효성을 체크합니다.
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(emailRegex);
	}


	// 메시지를 전송하는 메서드
	public void sendMessage(String recipientEmail, String message, int serviceChoice) {

		if (serviceChoice == 2) { //SMS일경우
			messagingService.sendMessage(recipientEmail, message);
		} else {
			if (isValidEmail(recipientEmail)) {
				messagingService.sendMessage(recipientEmail, message);
			} else {
				System.out.println("유효하지 않은 이메일 주소입니다. 메시지를 전송할 수 없습니다.");
			}
		}
	}

	public static void main(String[] args) {

		MessageProgram app = new MessageProgram();
		Scanner scanner = new Scanner(System.in);

		// 메시징 서비스 선택
		System.out.println("메시지 서비스를 선택하세요 (1: 이메일, 2: SMS):");
		int serviceChoice = scanner.nextInt();

		MetadataCollector messagingService;

		String chkValue = "";
		if (serviceChoice == 1) {

			messagingService = new EMailMetadataCollector();
			chkValue = "이메일 주소를";
		} else if (serviceChoice == 2) {

			messagingService = new SMSMetadataCollector();
			chkValue = "전화번호를";
		} else {
			System.out.println("잘못된 선택입니다. 기본적으로 이메일 서비스를 선택합니다.");
			messagingService = new EMailMetadataCollector();
		}

		app.setMessagingService(messagingService);


		// 이메일 주소 입력 받기
		System.out.println(chkValue + " 입력하세요:");
		scanner.nextLine(); // 버퍼 비우기
		String recipientEmail = scanner.nextLine();

		// 유효성 체크 후 메시지 입력 받기
		if (app.isValidEmail(recipientEmail)) {
			System.out.println("메시지를 입력하세요:");
			String message = scanner.nextLine();

			// 메시지 전송
			app.sendMessage(recipientEmail, message, serviceChoice);
		} else {
			if (serviceChoice == 2) {
				System.out.println("메시지를 입력하세요:");
				String message = scanner.nextLine();
				app.sendMessage(recipientEmail, message, serviceChoice);
			} else {
				System.out.println("유효하지 않은 이메일 주소입니다. 메시지를 전송할 수 없습니다.");
			}
		}

		scanner.close();



		FetchMetadata fetchMetadata1 = EMAILFetch.getInstance();
		ExportMetadata exportMetadata1 =  EMAILExport.getInstance();

		MetadataCollector mdcollector1 = new EMailMetadataCollector();
		setMetadataCollector(mdcollector1, fetchMetadata1, exportMetadata1);
		collectMetadata(mdcollector1);
		//print(mdcollector1);

		FetchMetadata fetchMetadata2 = SMSFetch.getInstance();
		ExportMetadata exportMetadata2 = SMSExport.getInstance();

		MetadataCollector mdcollector2 = new SMSMetadataCollector();
		setMetadataCollector(mdcollector2, fetchMetadata2, exportMetadata2);
		collectMetadata(mdcollector2);
		//print(mdcollector2);




			/*

		FetchMetadata fetchMetadata1 = JSONFetch.getInstance();
		ExportMetadata exportMetadata1 = PDFExport.getInstance();


		MetadataCollector mdcollector1 = new PDFMetadataCollector();
		setMetadataCollector(mdcollector1, fetchMetadata1, exportMetadata1);
		collectMetadata(mdcollector1);
		//print(mdcollector1);


	/*
		
		FetchMetadata fetchMetadata2 = XMLFetch.getInstance();
		ExportMetadata exportMetadata2 = CSVExport.getInstance();
		
		MetadataCollector mdcollector2 = new CSVMetadataCollector();
		setMetadataCollector(mdcollector2, fetchMetadata2, exportMetadata2);
		collectMetadata(mdcollector2);
		print(mdcollector2);

		*/

//		mdcollector.setMetadataCollector(fetchMetadata, exportMetadata);
//		mdcollector.collectMetadata();
//		mdcollector.print();
	}
}
