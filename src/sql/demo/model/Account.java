package sql.demo.model;


import java.util.Date;

/*`trans_info` (
		  `id` int(11) NOT NULL AUTO_INCREMENT,
		  `source_id` int(11) NOT NULL,
		  `source_account` varchar(20) NOT NULL,
		  `destination_id` int(11) NOT NULL,
		  `destination_account` varchar(20) NOT NULL,
		  `amount` double(18,2) NOT NULL DEFAULT '0.00',
		  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`id`)*/
public class Account {

	private Integer id;
	private Integer sourceId;
	private String account;
	private Integer destinationId;
	private String destinationAccount;
	private Double amount;
	private Date dateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	
	public Integer getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDestinationAccount() {
		return destinationAccount;
	}
	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
}
