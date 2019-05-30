package study.spring.myschool.service;

import java.util.List;
import study.spring.myschool.model.Department;

/** 학과 관리 기능을 제공하기 위한 Service 계층. */
public interface DepartmentService {

	/**
	 * 교수 등록하기
	 * 
	 * @param professor 저장할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	// --> import study.spring.myschool.model.Professor;
	public void addDepartment(Department department) throws Exception;

	/**
	 * 교수 수정하기
	 * 
	 * @param professor 수정할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	public void editDepartment(Department department) throws Exception;

	/**
	 * 교수 삭제하기
	 * 
	 * @param professor 삭제할 교수의 일련번호를 담고 있는 Beans
	 * @throws Exception
	 */
	public void deleteDepartment(Department department) throws Exception;

	/**
	 * 교수 상세 조회
	 * 
	 * @param professor 조회할 교수의 일련번호를 담고 있는 Beans
	 * @return 조회된 데이터가 저장된 Beans
	 * @throws Exception
	 */
	public Department getDepartmentItem(Department department) throws Exception;

	/**
	 * 교수 목록 조회
	 * 
	 * @return 조회 결과에 대한 컬렉션
	 * @throws Exception
	 */
	// -> import java.util.List;
	public List<Department> getDepartmentList(Department department) throws Exception;
	
	/**
	 * 전체 목록 수 조회
	 * @return 조회 결과
	 * @throws Exception
	 */
	public int getDepartmentCount(Department department) throws Exception;
	
	public List<Department> getDepartmentList2(Department department) throws Exception;
	
	
}