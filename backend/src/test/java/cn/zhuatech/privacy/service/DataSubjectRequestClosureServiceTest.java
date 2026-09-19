/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.privacy.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class DataSubjectRequestClosureServiceTest {
    private final DataSubjectRequestClosureService service = new DataSubjectRequestClosureService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void completesControlledDataSubjectRequest() {
        var result = service.assess(request(true, true, true, true));
        assertThat(result.decision()).isEqualTo(DataSubjectRequestClosureService.Decision.COMPLETE);
        assertThat(result.blockers()).isEmpty();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsRequestWithOutstandingActions() {
        var result = service.assess(request(false, false, false, false));
        assertThat(result.decision()).isEqualTo(DataSubjectRequestClosureService.Decision.REVIEW);
        assertThat(result.actions()).hasSize(4);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUncontrolledRequestClosure() {
        var result = service.assess(new DataSubjectRequestClosureService.Request("DSR-003", false, false,
                false, true, false, true, true, false, true, false, false, false));
        assertThat(result.decision()).isEqualTo(DataSubjectRequestClosureService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(8);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    private DataSubjectRequestClosureService.Request request(boolean sources, boolean exemptions,
                                                             boolean thirdParties, boolean deletionProof) {
        return new DataSubjectRequestClosureService.Request("DSR-001", true, true, true, sources, true,
                exemptions, thirdParties, true, deletionProof, true, true, true);
    }
}
