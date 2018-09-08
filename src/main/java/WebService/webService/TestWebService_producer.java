package WebService.webService;

import com.baizhi.service.ManagerServiceImp;

import javax.xml.ws.Endpoint;

public class TestWebService_producer {
    public static void main(String[] args) {
           /* //创建一个发布服务的对象
            JaxWsServerFactoryBean bean=new JaxWsServerFactoryBean();
            //设置服务的地址
            bean.setAddress("http://localhost:8999/UserService");
            //设置服务的对象
            bean.setServiceBean(new UserServiceImp());
            bean.setServiceClass(UserService.class);
            //发布服务
            bean.create();*/
        Endpoint.publish("http://localhost:8888/IDEAmanager", new ManagerServiceImp());
    }
}
