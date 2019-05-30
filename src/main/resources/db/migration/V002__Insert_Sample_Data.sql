-- Material Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Material" (id , "Description", "Identifier") VALUES (101, 'Milk', '30');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Material" (id , "Description", "Identifier") VALUES (102, 'Toner', '31');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Material" (id , "Description", "Identifier") VALUES (103, 'Kawa Lavazza1','33');

-- Inventory Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Inventory" (id , "ProductDescription", "Price", "Currency", "ShelfStock", "Location", "Image", "Status", "StatusColor", "StoringInstruction", "InStock", "Unit", "LifeRemaining", "LifeRemainingTreshold", "ItemType", "OrderingTreshold") VALUES (00002364, 'Broccoli Crowns', '2,99', 'USD', '27', 'Aisle 3, Section 5', 'assets/broccolli.png', 'Deteriorating', 'Error', 'Keep humidity level between 15% to 35%. Temperature between 3 - 6 °C', '190', 'Bags', '13%', 'Error', 'Perishable', 'Success');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Inventory" (id , "ProductDescription", "Price", "Currency", "ShelfStock", "Location", "Image", "Status", "StatusColor", "StoringInstruction", "InStock", "Unit", "LifeRemaining", "LifeRemainingTreshold", "ItemType", "OrderingTreshold") VALUES (1015346, 'Tortilla Chips', '4,99', 'USD', '35', 'Aisle 17, Section 5', 'assets/tortillachips.png', 'In-Stock', 'Success', 'Store in room temperate', '180', 'Boxes', '6 Months', 'Success', 'Non-Perishable', 'Error');

-- RequisitionHeader Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionHeader" (id , "RequisitionDescription", "NewAttribute") VALUES (201, 'Friday Requisition', 3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionHeader" (id , "RequisitionDescription", "NewAttribute") VALUES (202, 'May Requisitions', 100);

-- RequisitionItem Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionItem" (id, "ItemDescription", "Quantity", "Unit", "RequisitionHeader.ID") VALUES (10, 'Food', 10, 'kg', 201);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionItem" (id, "ItemDescription", "Quantity", "Unit", "RequisitionHeader.ID") VALUES (20, 'Devices', 8, '-', 201);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionItem" (id, "ItemDescription", "Quantity", "Unit", "RequisitionHeader.ID") VALUES (30, 'Kitchen equipment', 20, 'Pieces', 201);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionItem" (id, "ItemDescription", "Quantity", "Unit", "RequisitionHeader.ID") VALUES (40, 'Food', 15, 'kg', 202);
