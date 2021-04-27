/*
 Navicat Premium Data Transfer

 Source Server         : mandiri-academy
 Source Server Type    : PostgreSQL
 Source Server Version : 130002
 Source Host           : localhost:5432
 Source Catalog        : gold_pocket
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130002
 File Encoding         : 65001

 Date: 27/04/2021 22:35:09
*/


-- ----------------------------
-- Sequence structure for customer_customer_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_customer_id_seq";
CREATE SEQUENCE "public"."customer_customer_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."customer_customer_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for product_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_id_seq";
CREATE SEQUENCE "public"."product_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."product_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Table structure for m_customers
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_customers";
CREATE TABLE "public"."m_customers" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "first_name" varchar(30) COLLATE "pg_catalog"."default",
  "last_name" varchar(30) COLLATE "pg_catalog"."default",
  "birth_date" date,
  "address" text COLLATE "pg_catalog"."default",
  "status" int4,
  "username" varchar(30) COLLATE "pg_catalog"."default",
  "password" varchar(100) COLLATE "pg_catalog"."default",
  "email" varchar(100) COLLATE "pg_catalog"."default",
  "created_at" date,
  "updated_at" date
)
;
ALTER TABLE "public"."m_customers" OWNER TO "postgres";

-- ----------------------------
-- Records of m_customers
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_customers" VALUES ('ff80808178f8dea30178f8ded8fe0000', 'Ahmad', 'Invoker', '1998-09-09', 'Jl. Find and find', 1, 'ahmad', 'password', 'ahmaddazzle@gmail.com', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for m_history_prices
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_history_prices";
CREATE TABLE "public"."m_history_prices" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "history_date" timestamp(6),
  "price_buy" numeric(32,0),
  "price_sell" numeric(32,0),
  "product_id" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."m_history_prices" OWNER TO "postgres";

-- ----------------------------
-- Records of m_history_prices
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_history_prices" VALUES ('ff80808178fe0d190178fe14a37e0002', '2021-04-23 16:34:28.718', 859585, 859585, 'ff80808178f965fd0178f973f14b0001');
INSERT INTO "public"."m_history_prices" VALUES ('ff80808178fe152d0178fe1595ce0000', '2021-04-23 16:35:30.666', 8595885, 859585, 'ff80808178f965fd0178f973f14b0001');
INSERT INTO "public"."m_history_prices" VALUES ('ff80808179133ef301791354eb3e0003', '2021-04-27 19:36:42.927', NULL, NULL, 'ff80808179133ef301791354eb3b0002');
COMMIT;

-- ----------------------------
-- Table structure for m_pockets
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_pockets";
CREATE TABLE "public"."m_pockets" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "pocket_name" varchar(255) COLLATE "pg_catalog"."default",
  "pocket_qty" float4,
  "customer_id" varchar(100) COLLATE "pg_catalog"."default",
  "product_id" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."m_pockets" OWNER TO "postgres";

-- ----------------------------
-- Records of m_pockets
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_pockets" VALUES ('ff8080817912cec9017912e859d70003', 'Tabungan Hari Tua Emas', 2, 'ff80808178f8dea30178f8ded8fe0000', 'ff80808178f965fd0178f973f14b0001');
INSERT INTO "public"."m_pockets" VALUES ('ff808081791260d8017912612f850000', 'Tabungan Emasku', 41, 'ff80808178f8dea30178f8ded8fe0000', 'ff80808178f965fd0178f973f14b0001');
COMMIT;

-- ----------------------------
-- Table structure for m_products
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_products";
CREATE TABLE "public"."m_products" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "product_name" varchar(100) COLLATE "pg_catalog"."default",
  "product_price_buy" numeric,
  "product_price_sell" numeric,
  "product_image" varchar(100) COLLATE "pg_catalog"."default",
  "product_status" int4,
  "created_at" date,
  "updated_at" date
)
;
ALTER TABLE "public"."m_products" OWNER TO "postgres";

-- ----------------------------
-- Records of m_products
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_products" VALUES ('ff80808178fdba3a0178fdbbe0b10000', 'Perak', 844542, 859585, 'image-perak.jpg', 1, '2021-04-23', '2021-04-23');
INSERT INTO "public"."m_products" VALUES ('ff80808178f965fd0178f973f14b0001', 'Emas', 8595885, 859585, 'image-emas.jpg', 1, '2021-04-23', '2021-04-23');
INSERT INTO "public"."m_products" VALUES ('ff80808179133ef301791354eb3b0002', NULL, NULL, NULL, NULL, NULL, NULL, '2021-04-27');
COMMIT;

-- ----------------------------
-- Table structure for t_purchase_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchase_details";
CREATE TABLE "public"."t_purchase_details" (
  "purchase_detail_id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "price" numeric,
  "quantity_in_gram" float4,
  "product_id" varchar(100) COLLATE "pg_catalog"."default",
  "purchase_id" varchar(100) COLLATE "pg_catalog"."default",
  "pocket_id" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."t_purchase_details" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchase_details
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchase_details" VALUES ('ff8080817912cec90179131426e30005', 859585, 2, 'ff80808178f965fd0178f973f14b0001', 'ff8080817912cec90179131426df0004', 'ff808081791260d8017912612f850000');
INSERT INTO "public"."t_purchase_details" VALUES ('ff8080817912cec90179131426e30006', 859585, 1, 'ff80808178f965fd0178f973f14b0001', 'ff8080817912cec90179131426df0004', 'ff8080817912cec9017912e859d70003');
INSERT INTO "public"."t_purchase_details" VALUES ('ff80808179133ef30179135167b90001', 859585, 2, 'ff80808178f965fd0178f973f14b0001', 'ff80808179133ef30179135167b50000', 'ff808081791260d8017912612f850000');
INSERT INTO "public"."t_purchase_details" VALUES ('ff80808179139478017913a877610001', 859585, 1, 'ff80808178f965fd0178f973f14b0001', 'ff80808179139478017913a8775d0000', 'ff8080817912cec9017912e859d70003');
INSERT INTO "public"."t_purchase_details" VALUES ('ff8080817913bf6d017913c0952d0001', 859585, 2, 'ff80808178f965fd0178f973f14b0001', 'ff8080817913bf6d017913c0952a0000', 'ff808081791260d8017912612f850000');
INSERT INTO "public"."t_purchase_details" VALUES ('ff8080817913bf6d017913c4c5670003', 859585, 1, 'ff80808178f965fd0178f973f14b0001', 'ff8080817913bf6d017913c4c5670002', 'ff808081791260d8017912612f850000');
INSERT INTO "public"."t_purchase_details" VALUES ('ff8080817913bf6d017913c629440005', 859585, 100, 'ff80808178f965fd0178f973f14b0001', 'ff8080817913bf6d017913c629440004', 'ff808081791260d8017912612f850000');
INSERT INTO "public"."t_purchase_details" VALUES ('ff8080817913bf6d017913cc4b200007', 859585, 60, 'ff80808178f965fd0178f973f14b0001', 'ff8080817913bf6d017913cc4b200006', 'ff808081791260d8017912612f850000');
COMMIT;

-- ----------------------------
-- Table structure for t_purchases
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchases";
CREATE TABLE "public"."t_purchases" (
  "purchase_id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "purchase_date" date,
  "customer_id" varchar(100) COLLATE "pg_catalog"."default",
  "purchase_type" int2
)
;
ALTER TABLE "public"."t_purchases" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchases
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchases" VALUES ('ff8080817912cec90179131426df0004', '2021-04-27', 'ff80808178f8dea30178f8ded8fe0000', 0);
INSERT INTO "public"."t_purchases" VALUES ('ff80808179133ef30179135167b50000', '2021-04-27', 'ff80808178f8dea30178f8ded8fe0000', 0);
INSERT INTO "public"."t_purchases" VALUES ('ff80808179139478017913a8775d0000', '2021-04-27', 'ff80808178f8dea30178f8ded8fe0000', 0);
INSERT INTO "public"."t_purchases" VALUES ('ff8080817913bf6d017913c0952a0000', '2021-04-27', 'ff80808178f8dea30178f8ded8fe0000', 1);
INSERT INTO "public"."t_purchases" VALUES ('ff8080817913bf6d017913c4c5670002', '2021-04-27', 'ff80808178f8dea30178f8ded8fe0000', 1);
INSERT INTO "public"."t_purchases" VALUES ('ff8080817913bf6d017913c629440004', '2021-04-27', 'ff80808178f8dea30178f8ded8fe0000', 0);
INSERT INTO "public"."t_purchases" VALUES ('ff8080817913bf6d017913cc4b200006', '2021-04-27', 'ff80808178f8dea30178f8ded8fe0000', 1);
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."customer_customer_id_seq"
OWNED BY "public"."m_customers"."id";
SELECT setval('"public"."customer_customer_id_seq"', 8, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."product_id_seq"
OWNED BY "public"."m_products"."id";
SELECT setval('"public"."product_id_seq"', 6, true);

-- ----------------------------
-- Primary Key structure for table m_customers
-- ----------------------------
ALTER TABLE "public"."m_customers" ADD CONSTRAINT "m_customer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_history_prices
-- ----------------------------
ALTER TABLE "public"."m_history_prices" ADD CONSTRAINT "history_price_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_pockets
-- ----------------------------
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "m_pocket_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_products
-- ----------------------------
ALTER TABLE "public"."m_products" ADD CONSTRAINT "product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_purchase_details
-- ----------------------------
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "purchase_detail_pkey" PRIMARY KEY ("purchase_detail_id");

-- ----------------------------
-- Primary Key structure for table t_purchases
-- ----------------------------
ALTER TABLE "public"."t_purchases" ADD CONSTRAINT "purchase_pkey" PRIMARY KEY ("purchase_id");

-- ----------------------------
-- Foreign Keys structure for table m_history_prices
-- ----------------------------
ALTER TABLE "public"."m_history_prices" ADD CONSTRAINT "fk_product_history" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table m_pockets
-- ----------------------------
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "fk_pocket_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."m_customers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "fk_pocket_product" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchase_details
-- ----------------------------
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "fk_purchase_detail_product" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "fk_purchase_detail_purchase" FOREIGN KEY ("purchase_id") REFERENCES "public"."t_purchases" ("purchase_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchases
-- ----------------------------
ALTER TABLE "public"."t_purchases" ADD CONSTRAINT "fk_purchase_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."m_customers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
