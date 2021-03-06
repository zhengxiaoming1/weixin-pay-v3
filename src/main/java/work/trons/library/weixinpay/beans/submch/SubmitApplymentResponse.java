package work.trons.library.weixinpay.beans.submch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/10
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SubmitApplymentResponse extends BaseResponse {
    @JsonProperty("applyment_id")
    private Long applymentId;
}

