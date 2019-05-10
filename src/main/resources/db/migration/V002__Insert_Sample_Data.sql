-- Material Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Material" (id , "Description", "Identifier") VALUES (101, 'Milk', '30');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Material" (id , "Description", "Identifier") VALUES (102, 'Toner', '31');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Material" (id , "Description", "Identifier") VALUES (103, 'Kawa Lavazza1','33');

-- Inventory Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Inventory" (id , "ProductDescription", "Price", "Currency") VALUES (201, 'Broccoli Crowns', '2', 'USD');

-- RequisitionHeader Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionHeader" (id , "RequisitionDescription", "NewAttribute") VALUES (21, 'FridayRequisitions', 2);