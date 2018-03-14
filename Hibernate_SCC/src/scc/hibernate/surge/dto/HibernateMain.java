package scc.hibernate.surge.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class HibernateMain {

	public static void main(String[] args) {
		/* Test DAO methods */
		AccountDAO accounts = new AccountDAO();
		AccountDetails user_account = new AccountDetails();
		
		/*UUID uuid1 = UUID.randomUUID();
		UUID rand1 = UUID.randomUUID();
		UUID rand2 = UUID.randomUUID();
		user_account.setUuid(uuid);
		user_account.setFirstName("Ronald");
		user_account.setMiddleInitial('T');
		user_account.setLastName("Reagan");
		user_account.setEmail("email@email.org");
		user_account.setSecurePhone("securePhone");
		user_account.setAgency(rand1);
		user_account.setCitizenship(rand2);
		user_account.setClearance("TS:PPP");
		user_account.setAccountType("God");
		user_account.setAccountStatus("Active");
		user_account.setPassword("password");
		user_account.setLock(false);
		*/
		
		UUID uuid1 = UUID.fromString("f0b36bfa-4ed6-4709-9151-e73d0b783837");
		user_account.setUuid(uuid1);
		//accounts.addAccount(user_account);
		//accounts.updateAccount(user_account);
		//accounts.deleteAccount(user_account);
		
		List inDB = accounts.getAccounts();
		
		for (int i=0; i < inDB.size(); i++) {
			AccountDetails data = (AccountDetails) inDB.get(i);
			System.out.print("Name: " + data.getFirstName());
			System.out.print(" " + data.getLastName() + " " + "UUID: " + data.getUuid() + "\n");
		}
	}
		
		/* Build our sesssion to use for db interaction 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		AccountDetails account = new AccountDetails();
		Agencies agency = new Agencies();
		*/
		
		/* Set up Agency table 
		UUID agent_uuid = UUID.randomUUID();
		agency.setUuid(agent_uuid);
		agency.setAgency_name("NSA");
		agency.setLocation_id("ZZZ");
		commit(agency, session);
		agency = null;
		
		UUID agent_uuid2 = UUID.randomUUID();
		agency = new Agencies();
		agency.setUuid(agent_uuid2);
		agency.setAgency_name("DIA");
		agency.setLocation_id("YYY");
		commit(agency, session);
		*/
		
		/* Set up Account table
		UUID uuid = UUID.fromString("b491eb69-72b2-4577-8766-63cfe5a9b32f");
		account.setUuid(uuid);
		account.setFirstName("John");
		account.setLastName("Davis");
		account.setAgency(agent_uuid2);
		commit(account, session);
		*/
		
		
		/* Setup Location table 
		Location location = new Location();
		String string_uuid = "70b26c4b-4005-4ae3-a852-b5b227055b4c";
		String string_uuid2 = "3cae79e3-0857-46f4-a571-162e01757ab3";
		UUID state_uuid = UUID.fromString(string_uuid);
		UUID set_uuid = UUID.fromString(string_uuid2);
		
		location.setState(state_uuid);
		location.setUuid(set_uuid);
		location.setLocation_name("Texas");
		location.setLocation_id("TX");
		commit(location, session);
		*/
		
		/* Setup State table
		State state = new State();
		state.setAbbr("TX");
		state.setName("Texas");
		state.setUuid(state_uuid);  dependent on Location UUIDfromString for state_uuid
		commit(state, session);
		 */
		
		/* Setup Country table
		Country country = new Country();
		String string_uuid3 = "7aa65057-f930-40ce-990e-d2eaa78e0470";
		UUID country_uuid = UUID.fromString(string_uuid3);
		
		country.setAbbr("USA");;
		country.setName("United State of America");
		country.setUuid(country_uuid);
		commit(country, session);
		 */
		
		/* Setup Audit table 
		Audit audit = new Audit();
		String string_uuid4 = "df2fe4be-20c4-442d-ac66-ac06ed4cf303";
		UUID audit_uuid = UUID.fromString(string_uuid4);
		String string_uuid5 = "b491eb69-72b2-4577-8766-63cfe5a9b32f";
		UUID user_uuid2 = UUID.fromString(string_uuid5);
		
		audit.setEvent("Full System Audit");
		audit.setEventType("Audit");
		audit.setUuid(audit_uuid);
		audit.setUser_uuid(user_uuid2);
		commit(audit, session);
		*/
		
		/* Setup Application table
		Application app = new Application();
		UUID app_uuid = UUID.randomUUID();
		String timeZone = "UTC";
		String sysTime = getCurrentTimeStamp();
		String version="1.0";
		String build="Initial";
		Date releaseDate = new Date();
		String os="WIN";
		
		app.setUuid(app_uuid);
		app.setTimeZone(timeZone);
		app.setSysTime(sysTime);
		app.setVersion(version);
		app.setBuild(build);
		app.setReleaseDate(releaseDate);
		app.setOs(os);
		commit(app,session);
		*/
		
		/* Setup Application Notices table
		ApplicationNotices appNotice = new ApplicationNotices();
		UUID appNotice_uuid=UUID.randomUUID();
		Date setDate= new Date();
		
		appNotice.setUuid(appNotice_uuid);
		appNotice.setName("Initial");
		appNotice.setNotice("INITIAL CONFIG");
		appNotice.setDatetime(setDate);
		commit(appNotice, session);
		*/
		
		/* Setup Account State History
		AccountStateHistory ash = new AccountStateHistory();
		UUID rand1 = UUID.randomUUID();
		UUID rand2 = UUID.randomUUID();
		UUID rand3 = UUID.randomUUID();
		Date ash_now = new Date();
		
		ash.setUuid(rand1);
		ash.setAccount(rand2);
		ash.setAdmin(rand3);
		ash.setStatus("status");
		ash.setDate(ash_now);
		ash.setJustification("justification");
		commit(ash, session);
		*/
		
		
		
		/* Setup Documentation table 
		Documentation doc = new Documentation();
		UUID doc_uuid=UUID.randomUUID();
		
		doc.setUuid(doc_uuid);
		doc.setXmlTemplate("<XML TEMPLATE>");
		doc.setXlsTemplate("<xlsTemplate>");
		doc.setJsonTemplate("{jsonTemplate}");
		doc.setInstructions("instructions");
		doc.setApilmpDoc("apilmpDoc");
		commit(doc, session);
		*/
		
		/* Setup Document table 
		Document document = new Document();
		UUID document_uuid = UUID.randomUUID();
		
		document.setUuid(document_uuid);
		document.setLocation("location");
		commit(document, session);
		*/
		
		/* Setup Uploads table 
		Uploads uploads = new Uploads();
		UUID rand4 = UUID.randomUUID();
		UUID rand5 = UUID.randomUUID();
		UUID rand6 = UUID.randomUUID();
		Date up_now = new Date();
		long stamp = up_now.getTime();
		
		uploads.setUuid(rand4);
		uploads.setFileLocation("fileLocation");
		uploads.setDate(up_now);
		uploads.setType("type");
		uploads.setState(rand5);
		uploads.setAuthority(rand6);
		uploads.setStatus("status");
		uploads.setTimestamp(stamp);
		commit(uploads, session);
		*/
		
		/* Setup UploadProcessing 
		UploadsProcessing upProcess = new UploadsProcessing();
		
		upProcess.setUuid(rand4);		//dependent on rand4 in Uploads setup
		upProcess.setDocument(rand5);	//dependent on rand5 in Uploads setup
		upProcess.setUpload(rand6);		//dependent on rand6 in Uploads setup
		upProcess.setpCompletion(6);
		upProcess.setState("state");
		commit(upProcess, session);
		*/
		
		/* Setup ACAS_ProdRef 
		ACAS_ProdRef acas_prodRef = new ACAS_ProdRef();
		UUID rand7 = UUID.randomUUID();
		UUID rand8 = UUID.randomUUID();
		
		acas_prodRef.setUuid(rand7);
		acas_prodRef.setTopic("topic");
		acas_prodRef.setTopic_dialect("topic_dialect");
		acas_prodRef.setAddress("address");
		acas_prodRef.setMeta(rand8);
		commit(acas_prodRef, session);
		*/
		
		/* Setup ACAS_ARF_Message table */
		/* Setup ACAS_ARF_ReportObject table */
		/* Setup ACAS_Meta table */
		/* Setup ACAS_ARF_AR table */
		/* Setup ACAS_ARF_Device table */
		/* Setup ACAS_ARF_deviceID table */
		/* Setup ACAS_ARF_Identifier table */
		/* Setup ACAS_ARF_ID_FQDN table */
		/* Setup ACAS_ARF_OPATTR table */
		/* Setup ACAS_ARF_Config table */
		/* Setup ACAS_ARF_NETCONFIG table */
		/* Setup ACAS_ARF_Tagged table */
		/* Setup ACAS_ARF_cpeRecord table */
		/* Setup ACAS_ASR_PopulationCharacteristics table */
		/* Setup ACAS_ASR_BenchMarkID table */
		/* Setup ACAS_ASR_Benchmark table */
		/* Setup ACAS_ASR_RuleResult table */
		/* Setup ACAS_ASR_Message table */
		/* Setup ACAS_ASR_ResultsPackage table */
		/* Setup ACAS_ARF_NETINTID table */
		/* Setup ACAS_ARF_PlatformName table */
		/* Setup ACAS_ASR_Ident table */
		/* Setup ACAS_ASR_RuleComplianceItem table */
		/* Setup ACAS_ARF_HOSTDATA table */
		/* Setup ACAS_ARF_AN table */
		/* Setup ACAS_ASR_Result table */
		/* Setup ACAS_ARF_IP table */
		
		
		/* Fetch */
		//session = sessionFactory.openSession();
		//session.beginTransaction();
		//UUID uuid = UUID.randomUUID();
/*
		String target = "John";
		//String target = "Moriarty";
		//String target = "b491eb69-72b2-4577-8766-63cfe5a9b32f";
		AccountDetails user_uuid = null;
		try {
			UUID uuid1 = UUID.fromString(target);
			user_uuid = uuidfind(uuid1, agency, account, session);
		}
		catch (Exception e) {}
		
		try {
			AccountDetails name = firstNamefind(target, agency, account, session);
			AccountDetails last_name = lastNamefind(target, agency, account, session);
			
			
			String fetchOn = null;
			if (name.getFirstName() != null) {
				account=name;
				fetchOn="First Name";
			} else if (last_name.getFirstName() != null) {
				account=last_name;
				fetchOn="Last Name";
			} else if (user_uuid.getFirstName() != null) {
				account=user_uuid;
				fetchOn="UUID";
			}
			
			UUID agency_code = account.getAgency();
			agency = (Agencies) session.get(Agencies.class, agency_code);
			
			System.out.println("Match on: " + fetchOn);
			System.out.println("User Name retreived is " + account.getFirstName() + " " + account.getLastName());
			System.out.println("Agency associated is " + agency.getAgency_name());
			System.out.println("UUID for this account is " + account.getUuid());
			System.out.println("Agency UUID is " + agency.getUuid());
		}
		catch (Exception e) {
	     	throw e;
	 	}
		finally {
			/* Close our session 
			session.close();
		}
	}
*/	
	
	public static AccountDetails firstNamefind(String fname, String lname, Agencies agency, AccountDetails account, Session session) {
		
		Criteria criteria = session.createCriteria(AccountDetails.class);
		List<AccountDetails> list = (List<AccountDetails>) criteria.add(Restrictions.eq("firstName", fname)).list();
		
		for (int i=0; i < list.size(); i++) {
			account = list.get(i);
		}
		
		return account;
	}
	
	public static AccountDetails lastNamefind(String name, Agencies agency, AccountDetails account, Session session) {
		
		Criteria criteria = session.createCriteria(AccountDetails.class);
		List<AccountDetails> list = (List<AccountDetails>) criteria.add(Restrictions.eq("lastName", name)).list();
		
		for (int i=0; i < list.size(); i++) {
			account = list.get(i);
		}
		
		return account;
	}
	
	public static AccountDetails uuidfind(UUID uuid, Agencies agency, AccountDetails account, Session session) {
		
		Criteria criteria = session.createCriteria(AccountDetails.class);
		List<AccountDetails> list = (List<AccountDetails>) criteria.add(Restrictions.eq("uuid", uuid)).list();
		for (int i=0; i < list.size(); i++) {
			account = list.get(i);
		}
		return account;
	}
		
	public static void commit(Object data, Object session) {
		((SharedSessionContract) session).beginTransaction();
		((Session) session).save(data);
		((SharedSessionContract) session).getTransaction().commit();
	}
	
	public static String getCurrentTimeStamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
		
}
