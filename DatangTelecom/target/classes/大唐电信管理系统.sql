--drop table d_role;
--drop sequence seq_d_role;
--drop trigger trigger_seq_d_role;

create table d_role--��ɫ��
(
 role_id   number primary key,--��ɫ��ţ���������
 role_name varchar2(20) not null,--��ɫ����
  role_desc varchar2(30) not null--��ɫ����
);


create sequence seq_d_role;--��������

create or replace trigger trigger_seq_d_role
before insert on d_role
for each row
begin
select seq_d_role.nextval into :new.role_id from dual;
end trigger_seq_d_role;
/



create table d_employee--Ա��
(
  employee_id   number primary key,    --Ա����ţ���������
  employee_name varchar2(20) not null,  --�û����ƣ�
  password      varchar2(10) not null,    --���룬
  real_name     varchar2(20) not null,    --��ʵ������
  sex           varchar2(4) not null,    --�Ա�
  birthday      date,        --��������
  duty          varchar2(30) not null,    --ְλ��Ϣ
  enrolldate    date not null,      --��ְʱ��
  education     varchar2(30) not null,    --ѧ����Ϣ
  major         varchar2(30) not null,		--רҵ��Ϣ
  experience    varchar2(30) not null,		--��ҵ����
  role_id       number references d_role(role_id),	--�����������ɫ�����ý�ɫ���
  parent_id     number	references  d_employee(employee_id)--��������ܣ�����Ա�����
);

create sequence seq_d_employee;--��������

create or replace trigger trigger_seq_d_employee
before insert on d_employee
for each row
begin
select seq_d_employee.nextval into :new.employee_id from dual;
end trigger_seq_d_employee;
/


create table d_task--����
(
  task_id         number primary key,		--�����ţ���������
  task_name       varchar2(50),		--��������
  begin_date      date,			--��ʼʱ��
  end_date        date,			--����ʱ��
  real_begin_date date,			--ʵ�ʿ�ʼʱ��
  real_end_date   date,			--ʵ�ʽ���ʱ��
  status          varchar2(10),		--����״̬
  implementor_id  number references d_employee(employee_id),	--�����ʵʩ�˱�ţ�����Ա�����
  assigner_id     number references d_employee(employee_id),		--����������˱�ţ�����Ա�����
  task_desc       varchar2(100)		--��������
);


create sequence seq_d_task;--��������

create or replace trigger trigger_seq_d_task
before insert on d_task
for each row
begin
select seq_d_task.nextval into :new.task_id from dual;
end trigger_seq_d_task;
/


create table d_plan--�ƻ�
(
  plan_id       number primary key,		--�ƻ���ţ���������
  plan_name     varchar2(50),	--�ƻ�����
  status        varchar2(10),		--�ƻ�״̬
  is_feedback   varchar2(5),	--�Ƿ���
  begin_date    date,			--��ʼʱ��
  end_date      date,			--����ʱ��
  task_id       number references d_task(task_id),	--�����������������������
  feedback_info varchar2(100),	--������Ϣ
  plan_desc     varchar2(100)		--�ƻ�����
);


create sequence seq_d_plan;--��������

create or replace trigger trigger_seq_d_plan
before insert on d_plan
for each row
begin
select seq_d_plan.nextval into :new.plan_id from dual;
end trigger_seq_d_plan;
/

