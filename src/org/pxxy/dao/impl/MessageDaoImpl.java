package org.pxxy.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.pxxy.dao.MessageDao;
import org.pxxy.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDaoImpl implements MessageDao {

	@Autowired //按类型注入
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Message> findAllMessage() {
		return (List<Message>) hibernateTemplate.find("from Message");
	}

	@Override
	public void addMessage(Message message) {
		hibernateTemplate.save(message);
	}

	@Override
	public void delMessage(Message message) {
		hibernateTemplate.delete(message);
	}

	@Override
	public Message findMessageById(Integer id) {
		return hibernateTemplate.get(Message.class, id);
	}

	@Override
	public void updateMessage(Message message) {
		hibernateTemplate.update(message);
	}

	
}
