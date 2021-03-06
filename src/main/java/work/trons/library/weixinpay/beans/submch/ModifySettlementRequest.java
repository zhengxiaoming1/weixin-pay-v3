package work.trons.library.weixinpay.beans.submch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/11
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModifySettlementRequest {
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("account_bank")
    private String accountBank;
    @JsonProperty("bank_address_code")
    private String bankAddressCode;
    @JsonProperty("bank_name")
    private String bankName;
    @JsonProperty("bank_branch_id")
    private String bankBranchId;
    @JsonProperty("account_number")
    private String accountNumber;
}
