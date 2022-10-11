DROP SCHEMA IF EXISTS capstone cascade;
CREATE SCHEMA capstone;

CREATE TABLE capstone.USERS (
                             user_id uuid,
                             first_name varchar(150),
                             middle_name varchar(150),
                             last_Name varchar(150),
                             email varchar(150),
                             password varchar(150),
                             confirm_password varchar(150),
                             created_date TIMESTAMP WITH TIME ZONE,
                             modified_date TIMESTAMP WITH TIME ZONE,
                             PRIMARY KEY (user_id)
);

CREATE TABLE capstone.PROFILE (
                          member_id uuid,
                          email varchar(150),
                          contact_number varchar(150),
                          birthday varchar(150),
                          address varchar(150),
                          occupation varchar(150),
                          employer varchar(150),
                          position varchar(150),
                          image_link varchar(150),
                          created_date TIMESTAMP WITH TIME ZONE,
                          modified_date TIMESTAMP WITH TIME ZONE,
                          PRIMARY KEY (member_id)
);

CREATE TABLE capstone.Transaction (
                            transaction_id uuid,
                            date varchar(150),
                            trax_code varchar(150),
                            description varchar(150),
                            amount varchar(150),
                            created_date TIMESTAMP WITH TIME ZONE,
                            modified_date TIMESTAMP WITH TIME ZONE,
                            PRIMARY KEY (transaction_id)
);

CREATE TABLE capstone.INCOME (
                            income_id uuid,
                            income_from varchar(150),
                            amount varchar(150),
                            deposit_to varchar(150),
                            account_number varchar(150),
                            account_name varchar(150),
                            proof_trans varchar(150),
                            created_date TIMESTAMP WITH TIME ZONE,
                            modified_date TIMESTAMP WITH TIME ZONE,
                            PRIMARY KEY (income_id)
);

CREATE TABLE capstone.EXPENSE (
                                  expense_id uuid,
                                  expense_from varchar(150),
                                  amount varchar(150),
                                  withdrawn_from varchar(150),
                                  account_number varchar(150),
                                  image_link varchar(150),
                                  proof_trans varchar(150),
                                  created_date TIMESTAMP WITH TIME ZONE,
                                  modified_date TIMESTAMP WITH TIME ZONE,
                                  PRIMARY KEY (expense_id)
);

CREATE TABLE capstone.INVESTMENT (
                                     investment_id uuid,
                                     invested_to varchar(150),
                                     Platform_used varchar(150),
                                     withdrawn_from varchar(150),
                                     amount varchar(150),
                                     image_link varchar(150),
                                     proof_trans varchar(150),
                                     created_date TIMESTAMP WITH TIME ZONE,
                                     modified_date TIMESTAMP WITH TIME ZONE,
                                     PRIMARY KEY (investment_id)
);

CREATE TABLE capstone.MEMBERLIST (
                                      memberlist_id uuid,
                                      first_name varchar(150),
                                      last_name varchar(150),
                                      contact_number varchar(150),
                                      status varchar(150),

                                      created_date TIMESTAMP WITH TIME ZONE,
                                      modified_date TIMESTAMP WITH TIME ZONE,
                                      PRIMARY KEY (memberlist_id)
);

CREATE TABLE capstone.CONFIRM (
                                  confirm_id uuid,
                                  date varchar(150),
                                  trax_code varchar(150),
                                  description varchar(150),
                                  amount varchar(150),
                                  created_date TIMESTAMP WITH TIME ZONE,
                                  modified_date TIMESTAMP WITH TIME ZONE,
                                  PRIMARY KEY (confirm_id)
);