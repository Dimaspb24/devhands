CREATE TABLE product
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);