package org.pxxy.service.impl;

import java.util.List;

import org.pxxy.dao.MessageDao;
import org.pxxy.domain.Message;
import org.pxxy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired  //注入
	private MessageDao messageDao;

	@Override
	public List<Message> findAllMessage() {
		return messageDao.findAllMessage();
	}

	@Override
	public void addMessage(Message message) {
		//System.out.println("service:"+message.getCname());	
		messageDao.addMessage(message);
	}

	@Override
	public void delMessage(Message message) {
		messageDao.delMessage(message);
	}

	@Override
	public Message findMessageById(Integer id) {
		return messageDao.findMessageById(id);
	}

	@Override
	public void updateMessage(Message message) {
		messageDao.updateMessage(message);	
	}

	
}
