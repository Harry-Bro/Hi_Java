package mju_Swing.constants;

public class Constants {

	public enum EMainFrame {
		WIDTH(450),
		HEIGHT(600);
		
		private int size;
		
		EMainFrame(int size) {
			this.size = size;
		}
		
		public int getSize() {
			return this.size;
		}
	}
	
	public enum EMenuBar {
		FILE("File"),
		EDIT("Edit");
		
		private String text;
		
		EMenuBar(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		NEW("New"),
		OPEN("Oepn"),
		SAVE("Save"),
		SAVEAS("Save-As"),
		PRINT("Print"),
		EXIT("Exit")
		;
		
		private String text;
		
		EFileMenu(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		
		COPY("Copy"),
		CUT("Cut"),
		PASTE("Paste"),
		DELETE("Delete")
		;
		
		private String text;
		
		EEditMenu(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
	}
	
	public enum ETOOLBAR {
		
		BASKET("장바구니"),
		ENROLMENT("수강신청"),
		PRIVACY("개인정보"),
		GRADE("성적");
		
		private String text;
		
		ETOOLBAR(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
	}
	
	public enum ELoginDialog {
		width("300"),
		height("200"),
		nameLabel("아이디 "),
		sizeNameText("10"),
		passwordLabel("비밀번호"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	
}
