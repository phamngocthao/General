package fa.training.common;

import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class PageRouters {
	
	public static Map<PageRouterType, PageRouters> pageRouters = new HashMap();
	
	static {
		pageRouters.put(PageRouterType.ADD_COMPUTER_PAGE, new PageRouters("Thêm mới máy", "computer/add_computer.jsp", null));
		pageRouters.put(PageRouterType.LIST_COMPUTER_PAGE, new PageRouters("Danh sách máy", "computer/list_computer.jsp", "computer_script.jsp"));
		pageRouters.put(PageRouterType.REGISTER_USE_COMPUTER_PAGE, new PageRouters("Đăng ký dùng máy", "computer/register_use_computer.jsp", null));
		pageRouters.put(PageRouterType.ADD_CUSTOMER_PAGE, new PageRouters("Thêm mới khách hàng", "customer/add_customer.jsp", null));
		pageRouters.put(PageRouterType.LIST_CUSTOMER_PAGE, new PageRouters("Danh sách khách hàng", "customer/list_customer.jsp", "customer_script.jsp"));
		pageRouters.put(PageRouterType.PROFILE_CUSTOMER_PAGE, new PageRouters("Thông tin khách hàng", "customer/profile_customer.jsp", null));
		pageRouters.put(PageRouterType.ADD_SERVICE_PAGE, new PageRouters("Thêm mới dịch vụ", "service/add_service.jsp", null));
		pageRouters.put(PageRouterType.LIST_SERVICE_PAGE, new PageRouters("Danh sách dịch vụ", "service/list_service.jsp", "service_script.jsp"));
		pageRouters.put(PageRouterType.USE_SERVICE_PAGE, new PageRouters("Đăng ký dịch vụ", "service/use_service.jsp", null));
	}
	
	
	public static String routerPage(Model model,PageRouterType pageRouterType) {
		
		PageRouters pageRouter = pageRouters.get(pageRouterType);
		
		model.addAttribute("page",pageRouter);

		return "layout";
	}
	
	
	
	private String title;
	private String content;
	private String javaScript;
	
	
	public PageRouters(String title, String content, String javaScript) {
		super();
		this.title = title;
		this.content = content;
		this.javaScript = javaScript;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getJavaScript() {
		return javaScript;
	}


	public void setJavaScript(String javaScript) {
		this.javaScript = javaScript;
	}
	
	
	
	
}
