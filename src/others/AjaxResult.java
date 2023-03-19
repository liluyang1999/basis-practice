package others;

import java.io.Serial;
import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String CODE = "code";

    public static final String MSG = "msg";

    public static final String DATA = "data";

    public AjaxResult(Integer code, String msg, Object data) {
        this.put(CODE, code);
        this.put(MSG, msg);
        this.put(DATA, data);
    }

    public AjaxResult(Integer code, String msg) {
        this.put(CODE, code);
        this.put(MSG, msg);
    }

    public AjaxResult() {}

    /**
     * Return the success message
     */
    public static AjaxResult success(Integer code, String msg, Object data) {
        return new AjaxResult(code, msg, data);
    }
    public static AjaxResult success(String msg, Object data) {
        return AjaxResult.success(1, msg, data);
    }
    public static AjaxResult success(String msg) {
        return AjaxResult.success(1, msg, null);
    }
    public static AjaxResult success(Object data) {
        return AjaxResult.success(1, "success", data);
    }

    /**
     * Return the error message
     */
    public static AjaxResult error(Integer code, String msg) {
        return new AjaxResult(code, msg, null);
    }
    public static AjaxResult error(String msg) {
        return AjaxResult.error(0, msg);
    }
    public static AjaxResult error() {
        return AjaxResult.error(0, "error");
    }
}
