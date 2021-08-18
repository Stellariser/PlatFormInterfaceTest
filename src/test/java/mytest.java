import com.kaung.pogo.*;
import com.kaung.service.*;
import com.kaung.vo.ProperityQueryInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class mytest {

    @Test
    public void Usertext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService UserService = (UserService) context.getBean("UserServiceImpl");
        for (User User : UserService.queryAllUser()) {
            System.out.println(User);
        }

    }

    @Test
    public void getUsertext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService UserService = (UserService) context.getBean("UserServiceImpl");
        User admin = UserService.queryUserByName("admin");
        System.out.println(admin);


    }
    @Test
    public void getUsertexfhfdt(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService UserService = (UserService) context.getBean("UserServiceImpl");
        User admin = UserService.queryUserById(1);
        System.out.println(admin);


    }

    @Test
    public void getdatasetbyid(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatasetsService DatasetsService = (DatasetsService) context.getBean("DatasetsServiceImpl");
        Datasets admin = DatasetsService.queryDatasetsById(6);
        System.out.println(admin);

    }
    @Test
    public void queryUservaguetext(){
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery("a");
        queryInfo.setPageNumber(1);
        queryInfo.setPageSize(5);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService UserService = (UserService) context.getBean("UserServiceImpl");
        for (User User : UserService.queryUserVague(queryInfo)) {
            System.out.println(User);
        }
    }
    @Test
    public void queryScenevaguetext(){
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery("a");
        queryInfo.setPageNumber(1);
        queryInfo.setPageSize(5);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SceneService SceneService = (SceneService) context.getBean("SceneServiceImpl");
        for (Scene Scene : SceneService.querySceneVague(queryInfo)) {
            System.out.println(Scene);
        }
    }

    @Test
    public void queryScenetext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SceneService SceneService = (SceneService) context.getBean("SceneServiceImpl");
        for (Scene Scene : SceneService.queryScene()) {
            System.out.println(Scene);
        }
    }
    @Test
    public void queryClasscificationvaguetext(){
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery("a");
        queryInfo.setPageNumber(1);
        queryInfo.setPageSize(5);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClasscificationService ClasscificationService = (ClasscificationService) context.getBean("ClasscificationServiceImpl");
        for (Classcification Classcification : ClasscificationService.queryClasscificationVague(queryInfo)) {
            System.out.println(Classcification);
        }
    }

    @Test
    public void addaudit(){
        Audit Audit = new Audit();
        Audit.setId(6);
        Audit.setDataset_id(0);
        Audit.setDataset_name("Beijing");
        Audit.setSize(50000);
        Audit.setPurpose("asfsafgasg");
        Audit.setModifier("admin");
        Audit.setModify_time("2021-08-17 11:31:54");
        Audit.setStatus("未审核");
        Audit.setRemark("gasdgfaf");
        Audit.setAuditor(null);
        Audit.setAudit_time(null);
        Audit.setPath("asfas");
        Audit.setRecorder("asfasf");
        Audit.setRecord_place("safasf");
        Audit.setRecord_time("safasfsa");
        Audit.setCreate_time("2021-08-17 11:31:54");
        Audit.setCreate_person("fsaf");
        Audit.setType("修改数据集");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AuditService AuditService = (AuditService) context.getBean("AuditServiceImpl");
        AuditService.addAudit(Audit);

    }
    @Test
    public void updateaudit(){
        Audit Audit = new Audit();
        Audit.setId(6);
        Audit.setDataset_id(0);
        Audit.setDataset_name("Beijing");
        Audit.setSize(50000);
        Audit.setPurpose("asfsafgasg");
        Audit.setModifier("admin");
        Audit.setModify_time("2021-08-17 11:31:54");
        Audit.setStatus("未审核");
        Audit.setRemark("gasdgfaf");
        Audit.setAuditor(null);
        Audit.setAudit_time(null);
        Audit.setPath("asfas");
        Audit.setRecorder("asfasf");
        Audit.setRecord_place("safasf");
        Audit.setRecord_time("safasfsa");
        Audit.setCreate_time("2021-08-17 11:31:54");
        Audit.setCreate_person("fsaf");
        Audit.setType("修改数据集");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AuditService AuditService = (AuditService) context.getBean("AuditServiceImpl");
        AuditService.addAudit(Audit);

    }



    @Test
    public void datasettext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatasetsService DatasetsService = (com.kaung.service.DatasetsService) context.getBean("DatasetsServiceImpl");
        for (Datasets Datasets : DatasetsService.queryAllDatasets()) {
            System.out.println(Datasets);
        }

    }

    @Test
    public void queryTagtext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TagService TagService = (TagService) context.getBean("TagServiceImpl");
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery("1");
        queryInfo.setPageSize(5);
        queryInfo.setPageNumber(1);
        for (Tag Tag : TagService.queryTagVague(queryInfo)) {
            System.out.println(Tag);
        }
    }

    @Test
    public void queryDatasetsvaguetext(){
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery("");
        queryInfo.setPageNumber(1);
        queryInfo.setPageSize(5);
        int [] sceneList = {1};
        int [] classcificationList ={1};
        queryInfo.setSceneList(sceneList);
        queryInfo.setClasscificationList(classcificationList);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatasetsService DatasetsService = (DatasetsService) context.getBean("DatasetsServiceImpl");
        for (Datasets Datasets : DatasetsService.queryDatasetsVague(queryInfo)) {
            System.out.println(Datasets);
        }
    }
    @Test
    public void queryDatasetsvagueinitialtext(){
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery("");
        queryInfo.setPageNumber(1);
        queryInfo.setPageSize(5);
        queryInfo.setSceneList(null);
        queryInfo.setClasscificationList(null);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatasetsService DatasetsService = (DatasetsService) context.getBean("DatasetsServiceImpl");
        for (Datasets Datasets : DatasetsService.queryDatasetsVague(queryInfo)) {
            System.out.println(Datasets);
        }
    }

    @Test
    public void queryProperitytext(){
        int [] datasetsList = {4,5,6,7};
        int [] sceneList = {1,2,3,4,5};
        int [] classcificationList ={1,2,3,4,5,6};
        int [] tagList = {1};
        /*int [] nosceneList = {1,2};
        int [] noclasscificationList ={1,4};*/
        ProperityQueryInfo ProperityQueryInfo = new ProperityQueryInfo();
        ProperityQueryInfo.setQuery("");
        ProperityQueryInfo.setPageNumber(1);
        ProperityQueryInfo.setPageSize(5);
        ProperityQueryInfo.setDatasetList(datasetsList);
        ProperityQueryInfo.setSceneList(sceneList);
        ProperityQueryInfo.setClasscificationList(classcificationList);
        ProperityQueryInfo.setTagList(tagList);
        ProperityQueryInfo.setExtendLabel("1");
        /*ProperityQueryInfo.setNosceneList(nosceneList);
        ProperityQueryInfo.setNoclasscificationList(noclasscificationList);*/
        System.out.println(Arrays.toString(ProperityQueryInfo.getDatasetList()));
        System.out.println(Arrays.toString(ProperityQueryInfo.getClasscificationList()));
        System.out.println(Arrays.toString(ProperityQueryInfo.getSceneList()));
        System.out.println(ProperityQueryInfo.getSceneList().getClass());
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FrameProperityService FrameProperityService = (FrameProperityService) context.getBean("FrameProperityServiceImpl");
        for (FrameProperity FrameProperity : FrameProperityService.queryGlobalFrame(ProperityQueryInfo)) {
            System.out.println(FrameProperity);
        }
    }
    @Test
    public void timetest(){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(now);
    }
    @Test
    public void classcificationtext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClasscificationService ClasscificationService = (ClasscificationService) context.getBean("ClasscificationServiceImpl");
        for (Classcification Classcification : ClasscificationService.queryAllClasscification()) {
            System.out.println(Classcification);
        }

    }
    @Test
    public void datasetClasscificationtext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatasetToClasscificationService DatasetToClasscificationService = (DatasetToClasscificationService) context.getBean("DatasetToClasscificationServiceImpl");
        for (DatasetToClasscification DatasetToClasscification : DatasetToClasscificationService.queryAllDatasetToClasscification()) {
            System.out.println(DatasetToClasscification);
        }

    }
    @Test
    public void datasetscenetext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatasetToSceneService DatasetToSceneService = (DatasetToSceneService) context.getBean("DatasetToSceneServiceImpl");
        for (DatasetToScene DatasetToScene : DatasetToSceneService.queryAllDatasetToScene()) {
            System.out.println(DatasetToScene);
        }

    }
    @Test
    public void labeltext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FrameLabelService FrameLabelService = (FrameLabelService) context.getBean("FrameLabelServiceImpl");
        for (FrameLabel FrameLabel : FrameLabelService.queryAllFrameLabel()) {
            System.out.println(FrameLabel);
        }

    }
    @Test
    public void properitytext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FrameProperityService FrameProperityService = (FrameProperityService) context.getBean("FrameProperityServiceImpl");
        for (FrameProperity FrameProperity : FrameProperityService.queryAllFrameProperity()) {
            System.out.println(FrameProperity);
        }

    }
    @Test
    public void recursivetext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RecursiveService RecursiveService = (RecursiveService) context.getBean("RecursiveServiceImpl");
        for (Recursive Recursive : RecursiveService.queryAllRecursive()) {
            System.out.println(Recursive);
        }

    }
    @Test
    public void scenetext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SceneService SceneService = (SceneService) context.getBean("SceneServiceImpl");
        for (Scene Scene : SceneService.queryAllScene()) {
            System.out.println(Scene);
        }

    }
    @Test
    public void typetext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TypeService TypeService = (TypeService) context.getBean("TypeServiceImpl");
        for (Type Type : TypeService.queryAllType()) {
            System.out.println(Type);
        }

    }

    @Test
    public void Audittext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AuditService AuditService = (AuditService) context.getBean("AuditServiceImpl");
        for (Audit Audit : AuditService.queryAllAudit()) {
            System.out.println(Audit);
        }

    }

    @Test
    public void getAuditIdtext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AuditService AuditService = (AuditService) context.getBean("AuditServiceImpl");
        Audit admin = AuditService.queryAuditById(5);
        System.out.println(admin);

    }


}
