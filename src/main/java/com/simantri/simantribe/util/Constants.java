package com.simantri.simantribe.util;

public class Constants {

    public static final String SUCCESS_MSG_SUBMIT = "Data submitted.";
    public static final String SUCCESS_MSG_DATA_FOUND = "Here's your data.";
    public static final String ERR_MSG_NOTFOUND = "Data not found.";
    public static final String ON_PROCESS_DESC = "On Process";
    public static final String AWAITING_DESC = "Awaiting";
    public static final String DONE_DESC = "Finished Process";

    public enum QUEUE_STATUS {
        AWAITING("A", AWAITING_DESC),
        ON_PROCESS("OP", ON_PROCESS_DESC),
        FINISHED("F", DONE_DESC);

        private final String value;
        private final String desc;

        QUEUE_STATUS(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public String getMsg() {
            return desc;
        }
    }
}
