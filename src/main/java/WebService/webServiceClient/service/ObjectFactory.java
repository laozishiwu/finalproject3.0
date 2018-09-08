package WebService.webServiceClient.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.baizhi.service package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Update_QNAME = new QName("http://service.baizhi.com/", "update");
    private final static QName _QueryBynameResponse_QNAME = new QName("http://service.baizhi.com/", "queryBynameResponse");
    private final static QName _QueryBypage_QNAME = new QName("http://service.baizhi.com/", "queryBypage");
    private final static QName _Query_QNAME = new QName("http://service.baizhi.com/", "query");
    private final static QName _QueryResponse_QNAME = new QName("http://service.baizhi.com/", "queryResponse");
    private final static QName _QueryByidResponse_QNAME = new QName("http://service.baizhi.com/", "queryByidResponse");
    private final static QName _QueryByname_QNAME = new QName("http://service.baizhi.com/", "queryByname");
    private final static QName _QueryAll_QNAME = new QName("http://service.baizhi.com/", "queryAll");
    private final static QName _InsertResponse_QNAME = new QName("http://service.baizhi.com/", "insertResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://service.baizhi.com/", "deleteResponse");
    private final static QName _QueryAllResponse_QNAME = new QName("http://service.baizhi.com/", "queryAllResponse");
    private final static QName _UpdateResponse_QNAME = new QName("http://service.baizhi.com/", "updateResponse");
    private final static QName _Delete_QNAME = new QName("http://service.baizhi.com/", "delete");
    private final static QName _QueryByid_QNAME = new QName("http://service.baizhi.com/", "queryByid");
    private final static QName _Insert_QNAME = new QName("http://service.baizhi.com/", "insert");
    private final static QName _DeletesResponse_QNAME = new QName("http://service.baizhi.com/", "deletesResponse");
    private final static QName _QueryBypageResponse_QNAME = new QName("http://service.baizhi.com/", "queryBypageResponse");
    private final static QName _Deletes_QNAME = new QName("http://service.baizhi.com/", "deletes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.baizhi.service
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Update }
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link QueryBynameResponse }
     */
    public QueryBynameResponse createQueryBynameResponse() {
        return new QueryBynameResponse();
    }

    /**
     * Create an instance of {@link QueryBypage }
     */
    public QueryBypage createQueryBypage() {
        return new QueryBypage();
    }

    /**
     * Create an instance of {@link Query }
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link QueryResponse }
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link QueryByidResponse }
     */
    public QueryByidResponse createQueryByidResponse() {
        return new QueryByidResponse();
    }

    /**
     * Create an instance of {@link QueryByname }
     */
    public QueryByname createQueryByname() {
        return new QueryByname();
    }

    /**
     * Create an instance of {@link QueryAll }
     */
    public QueryAll createQueryAll() {
        return new QueryAll();
    }

    /**
     * Create an instance of {@link InsertResponse }
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link QueryAllResponse }
     */
    public QueryAllResponse createQueryAllResponse() {
        return new QueryAllResponse();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link Delete }
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link QueryByid }
     */
    public QueryByid createQueryByid() {
        return new QueryByid();
    }

    /**
     * Create an instance of {@link DeletesResponse }
     */
    public DeletesResponse createDeletesResponse() {
        return new DeletesResponse();
    }

    /**
     * Create an instance of {@link Insert }
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link QueryBypageResponse }
     */
    public QueryBypageResponse createQueryBypageResponse() {
        return new QueryBypageResponse();
    }

    /**
     * Create an instance of {@link Deletes }
     */
    public Deletes createDeletes() {
        return new Deletes();
    }

    /**
     * Create an instance of {@link Manager }
     */
    public Manager createManager() {
        return new Manager();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryBynameResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryBynameResponse")
    public JAXBElement<QueryBynameResponse> createQueryBynameResponse(QueryBynameResponse value) {
        return new JAXBElement<QueryBynameResponse>(_QueryBynameResponse_QNAME, QueryBynameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryBypage }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryBypage")
    public JAXBElement<QueryBypage> createQueryBypage(QueryBypage value) {
        return new JAXBElement<QueryBypage>(_QueryBypage_QNAME, QueryBypage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Query }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "query")
    public JAXBElement<Query> createQuery(Query value) {
        return new JAXBElement<Query>(_Query_QNAME, Query.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryResponse")
    public JAXBElement<QueryResponse> createQueryResponse(QueryResponse value) {
        return new JAXBElement<QueryResponse>(_QueryResponse_QNAME, QueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryByidResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryByidResponse")
    public JAXBElement<QueryByidResponse> createQueryByidResponse(QueryByidResponse value) {
        return new JAXBElement<QueryByidResponse>(_QueryByidResponse_QNAME, QueryByidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryByname }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryByname")
    public JAXBElement<QueryByname> createQueryByname(QueryByname value) {
        return new JAXBElement<QueryByname>(_QueryByname_QNAME, QueryByname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAll }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryAll")
    public JAXBElement<QueryAll> createQueryAll(QueryAll value) {
        return new JAXBElement<QueryAll>(_QueryAll_QNAME, QueryAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "insertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAllResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryAllResponse")
    public JAXBElement<QueryAllResponse> createQueryAllResponse(QueryAllResponse value) {
        return new JAXBElement<QueryAllResponse>(_QueryAllResponse_QNAME, QueryAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryByid }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryByid")
    public JAXBElement<QueryByid> createQueryByid(QueryByid value) {
        return new JAXBElement<QueryByid>(_QueryByid_QNAME, QueryByid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletesResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "deletesResponse")
    public JAXBElement<DeletesResponse> createDeletesResponse(DeletesResponse value) {
        return new JAXBElement<DeletesResponse>(_DeletesResponse_QNAME, DeletesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryBypageResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "queryBypageResponse")
    public JAXBElement<QueryBypageResponse> createQueryBypageResponse(QueryBypageResponse value) {
        return new JAXBElement<QueryBypageResponse>(_QueryBypageResponse_QNAME, QueryBypageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deletes }{@code >}}
     */
    @XmlElementDecl(namespace = "http://service.baizhi.com/", name = "deletes")
    public JAXBElement<Deletes> createDeletes(Deletes value) {
        return new JAXBElement<Deletes>(_Deletes_QNAME, Deletes.class, null, value);
    }

}
