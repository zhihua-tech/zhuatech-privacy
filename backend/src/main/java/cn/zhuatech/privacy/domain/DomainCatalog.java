/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.privacy.domain;
import org.springframework.stereotype.Component;
import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Component
public class DomainCatalog {
    private final Map<String, WorkflowAction> actions = new LinkedHashMap<>();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DomainCatalog() {
        actions.put("ASSESS", new WorkflowAction("ASSESS", "提交影响评估", List.of("草稿"), "评估中", "OPERATOR"));
        actions.put("APPROVE", new WorkflowAction("APPROVE", "批准处理活动", List.of("评估中"), "已批准", "ADMIN"));
        actions.put("RETIRE", new WorkflowAction("RETIRE", "终止处理活动", List.of("已批准"), "已终止", "ADMIN"));
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String systemName() { return "知华科技数据隐私合规平台"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String scene() { return "处理活动、数据地图、合法性基础、同意、主体请求、保留、跨境、评估与事件"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String initialStatus() { return "草稿"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String partyLabel() { return "处理活动/责任部门"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String amountLabel() { return "风险敞口"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String quantityLabel() { return "数据主体数"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String dueLabel() { return "合规期限"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<ModuleDefinition> modules() { return List.of(
            new ModuleDefinition("ROPA", "处理活动记录", "登记目的、范围、主体、数据项和接收方"),
            new ModuleDefinition("DATA_MAP", "个人信息地图", "定位采集、存储、共享和删除节点"),
            new ModuleDefinition("LEGAL_BASIS", "合法性基础", "记录同意、合同、法定义务等依据"),
            new ModuleDefinition("CONSENT", "同意管理", "管理授权版本、撤回和证明记录"),
            new ModuleDefinition("DSR", "主体权利请求", "受理访问、更正、删除和撤回请求"),
            new ModuleDefinition("RETENTION", "保留与删除", "配置保留期限并跟踪销毁证明"),
            new ModuleDefinition("CROSS_BORDER", "跨境管理", "评估跨境场景、接收方和保护措施"),
            new ModuleDefinition("PIA", "影响评估", "执行个人信息保护影响评估和审批"),
            new ModuleDefinition("INCIDENT", "隐私事件", "响应泄露、通知、整改和复盘")
        ); }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Map<String, WorkflowAction> actions() { return Collections.unmodifiableMap(actions); }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ModuleDefinition(String code,String name,String description) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record WorkflowAction(String code,String label,List<String> from,String to,String requiredRole) {}
}
