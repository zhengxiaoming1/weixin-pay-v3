package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.ecommerce.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.RSAUtils;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
public class EcommerceApi extends BaseApi {

    private EcommerceApi(PaySetting setting) {
        super(setting);
    }

    public static EcommerceApi with(PaySetting setting) {
        return new EcommerceApi(setting);
    }

    public SubmitApplymentResponse submitApplyment(SubmitApplymentRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/applyments/";
        if (request.getIdCardInfo() != null) {
            SubmitApplymentRequest.IdCardInfo idCardInfo = request.getIdCardInfo();
            idCardInfo.setIdCardName(RSAUtils.encrypt(idCardInfo.getIdCardName(), setting.getPlatformPublicKey()));
            idCardInfo.setIdCardNumber(RSAUtils.encrypt(idCardInfo.getIdCardNumber(), setting.getPlatformPublicKey()));
        }
        if (request.getAccountInfo() != null) {
            SubmitApplymentRequest.AccountInfo accountInfo = request.getAccountInfo();
            accountInfo.setAccountName(RSAUtils.encrypt(accountInfo.getAccountName(), setting.getPlatformPublicKey()));
            accountInfo.setAccountNumber(RSAUtils.encrypt(accountInfo.getAccountNumber(), setting.getPlatformPublicKey()));
        }

        SubmitApplymentRequest.ContactInfo contactInfo = request.getContactInfo();
        contactInfo.setContactName(RSAUtils.encrypt(contactInfo.getContactName(), setting.getPlatformPublicKey()));
        contactInfo.setContactIdCardNumber(RSAUtils.encrypt(contactInfo.getContactIdCardNumber(), setting.getPlatformPublicKey()));
        contactInfo.setMobilePhone(RSAUtils.encrypt(contactInfo.getMobilePhone(), setting.getPlatformPublicKey()));
        contactInfo.setContactEmail(RSAUtils.encrypt(contactInfo.getContactEmail(), setting.getPlatformPublicKey()));
        return jsonRequest(method, url, request, SubmitApplymentResponse.class);
    }

    public ApplymentResponse getApplyment(Long applymentId) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/applyments/%s", applymentId);
        return jsonRequest(method, url, null, ApplymentResponse.class);
    }

    public ApplymentResponse getApplyment(String outRequestNo) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/applyments/out-request-no/%s", outRequestNo);
        return jsonRequest(method, url, null, ApplymentResponse.class);
    }

    public GetSettlementResponse getSettlement(String subMchid) {
        String method = "GET";
        String url = String.format("/v3/apply4sub/sub_merchants/%s/settlement", subMchid);
        return jsonRequest(method, url, null, GetSettlementResponse.class);
    }

    public ModifySettlementResponse modifySettlement(String subMchid, ModifySettlementRequest request) {
        String method = "POST";
        request.setAccountNumber(RSAUtils.encrypt(request.getAccountNumber(), setting.getPlatformPublicKey()));
        String url = String.format("/v3/apply4sub/sub_merchants/%s/modify-settlement", subMchid);
        return jsonRequest(method, url, request, ModifySettlementResponse.class);
    }
}
