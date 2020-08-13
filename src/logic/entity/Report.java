// Bisogna aggiungere il riferimento ai feedback nell'entity user, anche dei messaggi. Come per servizi in library
package logic.entity;

public class Report {
	private String title;
	private String description;
	private long reportId;
	private String studentId;
	private String libraryId;
	private String status;

	public Report() {
	}

	public Report(String title, String description, long reportId, String studentId, String libraryId, String status) {
		this.title = title;
		this.description = description;
		this.reportId = reportId;
		this.studentId = studentId;
		this.libraryId = libraryId;
		this.status = status;
	}

	public Report(String title, String description, String studentId, String libraryId, String status) {
		this.title = title;
		this.description = description;
		this.studentId = studentId;
		this.libraryId = libraryId;
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMainInfoForLibrarian() {
		return this.title.concat("    ".concat(this.studentId.concat("    ".concat(this.status))));
	}
	
	public String getMainInfoForStudent() {
		return this.title.concat("    ".concat(this.libraryId.concat("    ".concat(this.status))));
	}

}
