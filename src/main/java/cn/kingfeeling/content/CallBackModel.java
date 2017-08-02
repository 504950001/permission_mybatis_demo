package cn.kingfeeling.content;

/**
 * @author zemal-tan
 * @description
 * @create 2017-08-02 10:26
 */
public class CallBackModel {
    public static Responses getSuccesResponse(Object result){
        return new Responses(
                ResponseConstants.SUCCESS_OK,
                ResponseConstants.CODE_SUCCESS,
                ResponseConstants.CODE_SUCCESS_VALUE,
                result);
    };

    public static Responses getErrorResponse(Object result, String errorMessage){
        return new Responses(
                ResponseConstants.SUCCESS_FAILED,
                ResponseConstants.CODE_FAILED,
                errorMessage,
                result);
    }
}
