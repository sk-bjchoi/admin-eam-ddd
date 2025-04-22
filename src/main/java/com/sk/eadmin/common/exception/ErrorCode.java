package com.sk.eadmin.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATE_TICKET		("TICKET_001", 		"동일한 번호로 이미 접수된 티켓이 존재합니다."),
    CANNOT_UPDATE_TICKET	("TICKET_002", 		"티켓이 수정 가능한 상태가 아닙니다."),
    CANNOT_DELETE_TICKET	("TICKET_003", 		"티켓이 삭제 가능한 상태가 아닙니다."),
    NOT_EXIST_TICKET		("TICKET_004", 		"존재하지 않는 티켓 아이디입니다."),
    NO_AVAILABLE_AGENT		("AGENT_001", 		"할당 가능한 담당자 없습니다."),
    INVALID_CUSTOMER_MOBILE	("CUSTOMER_001",	"접수 가능한 고객 핸드폰 번호가 아닙니다."),
    INVALID_REQUEST			("COMMON_400", "잘못된 요청입니다."),
    INTERNAL_ERROR			("COMMON_500", "서버 내부 오류입니다.");
	

    private final String code;
    private final String message;
}
