package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import entities.Contact;

@Transactional
public class ContactDAO {
	@Autowired
HibernateTemplate template;

public List<Contact> getAll()
{
	return template.loadAll(Contact.class);
}

public Integer save(Contact c)
{
	return (Integer) template.save(c);
}

public Contact getOne(int cid)
{
	return template.get(Contact.class,cid);
}

public void updateContact(Contact ct)
{
	template.update(ct);
}

}
