package work.trons.library.weixinpay.beans.combine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CombinePayResponse extends BaseResponse {
    @JsonProperty("prepay_id")
    private String prepayId;
}