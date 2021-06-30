package kr.rlog.batch.common;

import lombok.Getter;

/*
 * 게시글, 댓글, 방명록의 상태
 *
 * 공개 : ENABLE
 * 삭제 : UNABLE
 * 비밀 : SECRET
 * 임시 저장, 보호 : PROTECTED
 */
@Getter
public enum Status {
    ENABLE,
    UNABLE,
    SECRET,
    PROTECTED;
}
