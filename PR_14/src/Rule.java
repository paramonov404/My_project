public class Rule {
    private String replaceableStr;
    private String replacedStr;

    public Rule(String replaceableStr, String replacedStr) {
        this.replaceableStr = replaceableStr;
        this.replacedStr = replacedStr;
    }

    public String getReplaceableStr() {
        return replaceableStr;
    }

    public void setReplaceableStr(String replaceableStr) {
        this.replaceableStr = replaceableStr;
    }

    public String getReplacedStr() {
        return replacedStr;
    }

    public void setReplacedStr(String replacedStr) {
        this.replacedStr = replacedStr;
    }
}
