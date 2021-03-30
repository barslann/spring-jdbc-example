CREATE TABLE course(
    course_id integer identity NOT NULL,
    title varchar(80) NOT NULL, --course title
    description varchar(500) NOT NULL, --course description
    link varchar(255) NOT NULL,  --course landing page link
    CONSTRAINT pk_course_course_id PRIMARY KEY (course_id)
);