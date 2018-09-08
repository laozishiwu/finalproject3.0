package WebService.webServiceClient.service;

public class ClientTest {
    public static void main(String[] args) {
        ManagerServiceImpService managerServiceImpService = new ManagerServiceImpService();
        ManagerServiceImp managerServiceImp = managerServiceImpService.getPort(ManagerServiceImp.class);
        Manager manager = managerServiceImp.query("八戒", "bajie");
        managerServiceImp.queryAll();
        managerServiceImp.queryByid(9);
        System.out.println(manager);
        /*System.out.println(managerServiceImp.queryAll());
        System.out.println(managerServiceImp.queryByid(9));*/
    }
}
