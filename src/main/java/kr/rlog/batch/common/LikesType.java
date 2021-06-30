package kr.rlog.batch.common;

/*
 * 좋아요의 상태
 *
 * 공개 : ENABLE
 * 삭제 : UNABLE
 */
public enum LikesType {
    ENABLE,
    UNABLE;

    public static boolean isEnable(LikesType target) {
        return target == LikesType.ENABLE;
    }

    public static boolean isUnable(LikesType target) {
        return target == LikesType.UNABLE;
    }

}
