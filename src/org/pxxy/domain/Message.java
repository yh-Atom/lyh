package org.pxxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {

	@Id
	private Integer id;
	
	private String title1;
	
	private String content;
	
	private String time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private Integer qid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title1=" + title1 + ", content=" + content + ", time=" + time + ", qid=" + qid
				+ "]";
	}
	
	
	

	
	
	
}
