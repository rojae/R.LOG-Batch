package kr.rlog.batch.common;

import lombok.Getter;

/*
* 메일의 목적 타입
*
* USER_SIGNUP
* MAIL-UPDATE
* MAIL-EXPIRE
*/
@Getter
public enum MailType {
    USER_SIGNUP,
    MAIL_UPDATE,
    MAIL_EXPIRE;
}