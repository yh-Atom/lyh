package org.pxxy.dao;

import java.util.List;

import org.pxxy.domain.Message;

public interface MessageDao {

	List<Message> findAllMessage();

	void addMessage(Message message);

	void delMessage(Message message);

	Message findMessageById(Integer Id);

	void updateMessage(Message message);

}
