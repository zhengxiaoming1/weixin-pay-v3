package work.trons.library.weixinpay.beans.pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/11
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryOrderResponse extends BaseResponse {
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("mchid")
    private String mchid;
    @JsonProperty("trade_state")
    private String tradeState;
    @JsonProperty("bank_type")
    private String bankType;
    @JsonProperty("success_time")
    private String successTime;
    @JsonProperty("payer")
    private Payer payer;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("appid")
    private String appid;
    @JsonProperty("trade_state_desc")
    private String tradeStateDesc;
    @JsonProperty("trade_type")
    private String tradeType;
    @JsonProperty("attach")
    private String attach;
    @JsonProperty("scene_info")
    private SceneInfo sceneInfo;
    @JsonProperty("promotion_detail")
    private List<PromotionDetail> promotionDetail;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Amount {
        @JsonProperty("payer_total")
        private Integer payerTotal;
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("payer_currency")
        private String payerCurrency;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payer {
        @JsonProperty("openid")
        private String openid;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SceneInfo {
        @JsonProperty("device_id")
        private String deviceId;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PromotionDetail {
        @JsonProperty("amount")
        private Integer amount;
        @JsonProperty("wechatpay_contribute")
        private Integer wechatpayContribute;
        @JsonProperty("coupon_id")
        private String couponId;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("merchant_contribute")
        private Integer merchantContribute;
        @JsonProperty("name")
        private String name;
        @JsonProperty("other_contribute")
        private Integer otherContribute;
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("type")
        private String type;
        @JsonProperty("stock_id")
        private String stockId;
        @JsonProperty("goods_detail")
        private List<GoodsDetail> goodsDetail;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class GoodsDetail {
            @JsonProperty("goods_remark")
            private String goodsRemark;
            @JsonProperty("quantity")
            private Integer quantity;
            @JsonProperty("discount_amount")
            private Integer discountAmount;
            @JsonProperty("goods_id")
            private String goodsId;
            @JsonProperty("unit_price")
            private Integer unitPrice;
        }
    }
}
