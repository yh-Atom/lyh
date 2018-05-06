package org.pxxy.service;

import java.util.List;
import org.pxxy.domain.Message;

public interface MessageService {

	List<Message> findAllMessage();

	void addMessage(Message message);

	void delMessage(Message message);

	Message findMessageById(Integer integer);

	void updateMessage(Message message);

}
