package com.sk.eadmin.biz.admin.domain.entity;

import java.util.List;

import com.sk.eadmin.biz.admin.domain.vo.ProblemCategoryVO;
import com.sk.eadmin.biz.admin.domain.vo.ProblemDegreeVO;
import com.sk.eadmin.biz.admin.domain.vo.ProgressStatusVO;
import com.sk.eadmin.common.code.CodeEnumUtils;
import com.sk.eadmin.common.exception.DomainException;
import com.sk.eadmin.common.exception.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProblemTicketEntity{
	private String toDo;
}
