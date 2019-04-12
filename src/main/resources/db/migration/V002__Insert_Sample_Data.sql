-- AdministrationUnitType Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnitType" (id , "Description", "Identifier") VALUES (101, 'Hauptverwaltung', '30');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnitType" (id , "Description", "Identifier") VALUES (102, 'Bezirk', '31');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnitType" (id , "Description", "Identifier") VALUES (103, 'Senatsverwaltung','33');

-- AdministrationUnit Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (101, 'Hauptverwaltung', 30, true, 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (102, 'Mitte', 31, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (103, 'Friedrichshain-Kreuzberg', 32, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (104, 'Pankow', 33, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (105, 'Charlottenburg-Wilmersdorf', 34, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (106, 'Spandau', 35, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (107, 'Steglitz-Zehlendorf', 36, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (108, 'Tempelhof-Schöneberg', 37, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (109, 'Neukölln', 38, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (110, 'Treptow-Köpenick', 39, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (111, 'Marzahn-Hellersdorf', 40, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (112, 'Lichtenberg', 41, true, 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnit" (id , "Identifier", "KeyFigure", "IsActive", "AssignedAdministrationUnitType.ID") VALUES (113, 'Reinickendorf', 42, true, 102);

-- BudgetPlan Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetPlan" (id, "Name", "Type", "Year1", "Year2", "IsDeleted") VALUES (101, 'Haushalt 2018/2019', 0, 2018, 2019, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetPlan" (id, "Name", "Type", "Year1", "Year2", "IsDeleted") VALUES (102, 'Nachtraghaushalt 2018/2019', 1, 2018, 2019, false);


-- NegotiationRound Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (101, 'Runde 0', 0, 101, 101, 0, 'Initiale Einstellungen');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (102, 'Runde 1', 1, 101, 101, 0, 'Ressortanmeldung');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (103, 'Runde 2', 2, 101, 101, 0, 'Verhandlungsrunde');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (113, 'Runde 3', 3, 101, 101, 0, 'Verhandlungsrunde2');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (104, 'Runde 0', 0, 102, 102, 1, 'Initiale Einstellungen');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (105, 'Runde 1', 1, 102, 102, 0, 'Ressortanmeldung');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (106, 'Runde 2', 2, 102, 102, 0, 'Verhandlungsrunde');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (107, 'Runde 0', 0, 102, 103, 1, 'Initiale Einstellungen');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (108, 'Runde 1', 1, 102, 103, 0, 'Ressortanmeldung');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (109, 'Runde 2', 2, 102, 103, 0, 'Verhandlungsrunde');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (110, 'Runde 3', 3, 102, 103, 0, 'Parlamentarische Beratung');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound" (id, "Name", "Number", "AssignedBudgetPlan.ID", "AssignedAdministrationUnit.ID", "State", "Description") VALUES (111, 'Runde 4', 4, 102, 103, 0, 'Haushaltsplan finalisieren');

-- Section Data---- Permission Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (101, '5', 2, true, true, true, true, 101);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (102, '6', 'Einzelplan', 1, 1, 1, 1, 102);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (103, '7', 'Einzelplan', 1, 1, 1, 1, 103);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (104, '500', 'Kapitel', 1, 1, 1, 1, 101);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (105, '501', 'Kapitel', 1, 1, 1, 1, 102);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (106, '502', 'Kapitel', 1, 1, 1, 1, 103);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (110, '11002', 'Title', 1, 1, 1, 1, 104);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (111, '11003', 'Title', 1, 1, 1, 1, 105);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (112, '11004', 'Title', 1, 1, 1, 1, 106);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (113, null, 'Title', 1, 1, 1, 1, 101);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (114, null, 'Kapitel', 1, 1, 1, 1, 101);
--INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission" (id, "ObjectIdentifier", "ObjectType", "PermissionCreate", "PermissionUpdate", "PermissionDelete", "PermissionRead", "AssignedNegotiationRound.ID") VALUES (115, null, 'Einzelplan', 1, 1, 1, 1, 101);
--

-- Section Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Section" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedNegotiationRound.ID", "IsDeleted") VALUES (101, 1, 'Abgeordnetenhaus', 'Abgeordnetenhaus', 101, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Section" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedNegotiationRound.ID", "IsDeleted") VALUES (102, 2, 'Verfassungsgerichtshof', 'Verfassungsgerichtshof', 102, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Section" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedNegotiationRound.ID", "IsDeleted") VALUES (103, 3, 'Regierende/r Bürgermeister/in', 'Regierende/r Bürgermeister/in', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Section" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedNegotiationRound.ID", "IsDeleted") VALUES (104, 5, 'Inneres und Sport', 'Inneres und Sport', 104, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Section" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedNegotiationRound.ID", "IsDeleted") VALUES (105, 6, 'Justiz und Verbraucherschutz', 'Justiz und Verbraucherschutz', 105, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Section" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedNegotiationRound.ID", "IsDeleted") VALUES (106, 1, 'Abgeordnetenhaus', 'Abgeordnetenhaus', 102, false);

-- Chapter Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (101, 100, 'Abgeordnetenhaus', 'Abgeordnetenhaus', 101, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (102, 109, 'Abgeordnetenhaus - Personalüberhang -', 'Abgeordnetenhaus - Personalüberhang -', 101, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (103, 200, 'Verfassungsgerichtshof', 'Verfassungsgerichtshof', 102, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (104, 300, 'Senatskanzlei', 'Senatskanzlei', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (105, 309, 'Senatskanzlei - Personalüberhang -', 'Senatskanzlei - Personalüberhang -', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (106, 310, 'Kulturelle Angelegenheiten', 'Kulturelle Angelegenheiten', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (107, 312, 'Brücke-Museum', 'Brücke-Museum', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (108, 313, 'Gedenkstätte Deutscher Widerstand', 'Gedenkstätte Deutscher Widerstand', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (109, 314, 'Landesarchiv', 'Landesarchiv', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (110, 319, 'Kulturelle Angelegenheiten - Personalüberhang -', 'Kulturelle Angelegenheiten - Personalüberhang -', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (111, 320, 'Leistungen an die Kirchen, Religions- und Weltanschauungsgemeinschaften', 'Leistungen an die Kirchen, Religions- und Weltanschauungsgemeinschaften', 103, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (112, 500, 'Senatsverwaltung für Inneres und Sport - Politisch-Administrativer Bereich und Service -', 'Senatsverwaltung für Inneres und Sport - Politisch-Administrativer Bereich und Service -', 104, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (113, 505, 'Senatsverwaltung für Inneres und Sport - Berlinweites E-Government -', 'Senatsverwaltung für Inneres und Sport - Berlinweites E-Government -', 104, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (114, 509, 'Senatsverwaltung für Inneres und Sport - Personalüberhang -', 'Senatsverwaltung für Inneres und Sport - Personalüberhang -', 104, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (115, 510, 'Senatsverwaltung für Inneres und Sport - Sport -', 'Senatsverwaltung für Inneres und Sport - Sport -', 104, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (116, 511, 'Olympiapark', 'Olympiapark', 104, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (117, 512, 'Sportforum', 'Sportforum', 104, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (118, 611, 'Generalstaatsanwaltschaft', 'Generalstaatsanwaltschaft', 105, true);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (119, 612, 'Staatsanwaltschaft', 'Staatsanwaltschaft', 105, true);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (120, 613, 'Amtsanwaltschaft', 'Amtsanwaltschaft', 105, true);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (121, 615, 'Kammergericht', 'Kammergericht', 105, true);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (122, 616, 'Landgericht', 'Landgericht', 105, true);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (123, 619, 'Amtsgericht Charlottenburg', 'Amtsgericht Charlottenburg', 105, true);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (124, 621, 'Amtsgericht Köpenick', 'Amtsgericht Köpenick', 105, true);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (125, 100, 'Abgeordnetenhaus', 'Abgeordnetenhaus', 106, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter" (id, "KeyFigure", "LongIdentifier", "ShortIdentifier", "AssignedSection.ID", "IsDeleted") VALUES (126, 109, 'Abgeordnetenhaus - Personalüberhang -', 'Abgeordnetenhaus - Personalüberhang -', 106, false);

-- ActivityGroup
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActivityGroup" (id, "KeyFigure","Identifier", "IsActive", "Explanation") VALUES (101, 31, 'Ausgaben für verfahrensunabhängige IuK',true, 'Erklärung für Ausgaben für verfahrensunabhängige IuK');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActivityGroup" (id, "KeyFigure","Identifier", "IsActive", "Explanation") VALUES (102, 32, 'Ausgaben für verfahrensabhängige IuK',true, 'Erklärung für Ausgaben für verfahrensabhängige IuK');

-- CostType
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.CostType" (id, "KeyFigure","Identifier") VALUES (101, 500, 'Personal');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.CostType" (id, "KeyFigure","Identifier") VALUES (102, 550, 'Finanzen und Administration');

-- CostCenter
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.CostCenter" (id, "KeyFigure","Identifier") VALUES (101, 500, 'Büro und Gebäude');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.CostCenter" (id, "KeyFigure","Identifier") VALUES (102, 500, 'Sonstige Ausgaben');

-- Function
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Function" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (101, 0, 'Allgemeine Dienste',null,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Function" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (102, 10, 'Politische Führung und zentrale Verwaltung',101,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Function" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (103, 11, 'Politische Führung',102,2);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Function" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (104, 12, 'Innere Verwaltung',102,2);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Function" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (105, 13, 'Informationswesen',102,2);

-- FinanceplanPos
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (101, 1000,    'Einnahmen der laufenden Rechnung', null, 0,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (102, 1100,   'Steuern',101, 1,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (103, 1200,   'steuerähnliche Abgaben',101, 1,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (104, 1500,   'laufende Zuweisungen und Zuschüsse',101,1,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (105, 1510,  'vom öffentlichen Bereich',104,2,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (106, 1511, 'vom Bund',105,3,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (107, 1512, 'Länderfinanzausgleich',105,3,0);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (108, 2000,    'Ausgaben der laufenden Rechnung',null,0,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (109, 2100,   'Personalausgaben',108,1,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (110, 2200,   'laufender Sachaufwand',108,1,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (111, 2210,  'sächliche Verwaltungsausgaben',110,2,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (112, 2211,   'laufende Zuweisungen und Zuschüsse',111,2,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (113, 2212,  'an öffentlichen Bereich',111,2,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (114, 2214, 'an Bund',111,3,1);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FinanceplanPos" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","ERFlag") VALUES (115, 2213, 'sonstige an Länder',111,3,1);

-- ActualData
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (101, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (102, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (103, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (104, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (105, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (106, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (107, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (108, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (109, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (110, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (111, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (112, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (113, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (114, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (115, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (116, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ActualData" (id, "ActualValuePY1", "ActualValuePY2", "PredictionValuePY1", "PredictionValuePY2", "RemainingValuePY1", "RemainingValuePY2") VALUES (117, '155987.33', '987656.48', '354824.97', '134682.65', '815324.13', '875246.27');

-- PlanningData
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (101, '236630', '319780', '340302', '398165', '428233');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (102, '658254', '365480', '987552', '632416', '968545');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (103, '987698', '312340', '901657', '657821', '321654');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (104, '876354', '384580', '875466', '987512', '894122');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (105, '554625', '987546', '667853', '982045', '976345');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (106, '878788', '986586', '978675', '321354', '284361');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (107, '213255', '222733', '132435', '316479', '548792');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (108, '878975', '438462', '948560', '648522', '654847');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (109, '979752', '574621', '157245', '254523', '321548');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (110, '667325', '987434', '293874', '542124', '781576');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (111, '384654', '319780', '791123', '987635', '311549');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (112, '087654', '876777', '766845', '321547', '314857');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (113, '854561', '432657', '113342', '135485', '981651');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (114, '427325', '977434', '293874', '542124', '781576');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (115, '284654', '199780', '791123', '987635', '311549');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (116, '187654', '586777', '766845', '321547', '314857');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.PlanningData" (id, "EstimatePY1", "EstimatePY2", "EstimatePY3", "EstimatePY4", "EstimatePY5") VALUES (117, '754561', '102657', '113342', '135485', '981651');

-- Title Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag", "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (101, 11201,1, 'Geldstrafen, Geldbußen, Verwarnungs- und Zwangsgelder', '', 'Geldstrafen, Geldbußen, Verwarnungs- und Zwangsgelder', 101,101,101,101,101,102,113,107, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag","LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (102, 11906,1, 'Ersatz von Fernmeldegebühren', '', 'Ersatz von Fernmeldegebühren', 101,102,101,102,101,102,112,106, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag", "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (103, 11961,0, 'Erstattung von Steuerbeträgen', '', 'Erstattung von Steuerbeträgen', 101,102,102,102,101,102,111,105, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (104, 11979,0, 'Verschiedene Einnahmen', '', 'Verschiedene Einnahmen', 101,102,101,101,101,103,110,104, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (105, 42801,1, 'Entgelte der planmäßigen Tarifbeschäftigten', '', 'Entgelte der planmäßigen Tarifbeschäftigten', 102,102,101,101,102,102,109,103, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (106, 52601,0, 'Gerichts- und ähnliche Kosten', '', 'Gerichts- und ähnliche Kosten', 102,101,101,101,101,104,108,102, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (107, 52703,0, 'Dienstreisen', '', 'Dienstreisen', 102,102,101,102,101,104,107,101, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (108, 42201,1, 'Bezüge der planmäßigen Beamten/Beamtinnen', '', 'Bezüge der planmäßigen Beamten/Beamtinnen', 102,102,102,102,102,104,106,108, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (109, 11009,1, 'Veranstaltungen', '', 'Veranstaltungen', 102,102,101,101,102,104,105,109, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (110, 11903,0, 'Schadenersatzleistungen, Vertragsstrafen', '', 'Schadenersatzleistungen, Vertragsstrafen', 103,102,101,101,102,104,104,110, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (111, 11906,0, 'Ersatz von Fernmeldegebühren', '', 'Ersatz von Fernmeldegebühren', 104,102,101,101,102,104,103,111, false,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (112, 54608,0, 'Einrichtung und Steuerung des Musicboards', '', 'Einrichtung und Steuerung des Musicboards', 104,102,101,101,102,104,102,112, true,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted","TitleClassification") VALUES (113, 68119,0, 'Förderung von Künstlern/Künstlerinnen', '', 'Förderung von Künstlern/Künstlerinnen', 105,102,101,101,102,104,101,113, true,3);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag", "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted") VALUES (114, 11201,1, 'Geldstrafen, Geldbußen, Verwarnungs- und Zwangsgelder', '', 'Geldstrafen, Geldbußen, Verwarnungs- und Zwangsgelder', 125,101,101,101,101,102,117,114, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag","LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted") VALUES (115, 11906,1, 'Ersatz von Fernmeldegebühren', '', 'Ersatz von Fernmeldegebühren', 125,102,101,102,101,102,116,115, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag", "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted") VALUES (116, 11961,0, 'Erstattung von Steuerbeträgen', '', 'Erstattung von Steuerbeträgen', 125,102,102,102,101,102,115,116, false);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title" (id, "KeyFigure", "ERFlag",  "LongIdentifier", "ReasonDisputable", "ShortIdentifier", "AssignedChapter.ID","AssignedActivityGroup.ID","AssignedCostType.ID","AssignedCostCenter.ID","AssignedFunction.ID","AssignedFinanceplanPos.ID", "AssignedPlanningData.ID", "AssignedActualData.ID", "IsDeleted") VALUES (117, 11979,0, 'Verschiedene Einnahmen', '', 'Verschiedene Einnahmen', 125,102,101,101,101,103,114,117, false);

-- ChapterGrouping
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ChapterGrouping" (id, "KeyFigure","Identifier","Type","Explanation") VALUES (102, 500, 'Verwaltungseinnahmen, Einnahmen aus Schuldendienst und dgl.',0,'Explanation');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ChapterGrouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","Explanation") VALUES (103, 520, 'Verwaltungseinnahmen',102,1,'Explanation');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ChapterGrouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","Explanation") VALUES (104, 510, 'Gebühren, sonstige Entgelte',102,1,'Explanation');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.ChapterGrouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type","Explanation") VALUES (105, 521, 'Geldstrafen, Geldbußen und Zwangsgelder - einschließlich der damit zusammenhängenden Gerichts- und Verwaltungskosten)',103,2,'Explanation');

-- Grouping
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","Type") VALUES (102, 0, 'Einnahmen aus Steuern und steuerähnlichen Abgaben sowie EU-Eigenmittel',0);
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (103, 10,  'Gemeinschaftssteuern- und Gewerbesteuerumlage',102,1);
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (104, 11, 'Lohnsteuer',103,2);
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (105, 12, 'Veranlagte Einkommensteuer',103,2);
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (106, 30,  'Bundessteuern',102,1);
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (107, 31, 'Energiesteuer',106,2);
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (108, 32, 'Tabaksteuer',106,2);
 INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Grouping" (id, "KeyFigure","Identifier","AssignedParent.ID","Type") VALUES (109, 33, 'Branntweinmonopol',106,2);

 --- CommitmentAuthorization Data
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.CommitmentAuthorization" (id, "Value", "Year", "RelatedYear", "Description", "AssignedTitle.ID" ) VALUES (101, 300000, 2018, 2018, 'Beispielposition in Verpflichtungen', 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.CommitmentAuthorization" (id, "Value", "Year", "RelatedYear", "Description", "AssignedTitle.ID" ) VALUES (102, 25000, 2015, 2019, 'Beispielposition 2 in Verpflichtungen', 101);

-- BudgetMemoType
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoType" (id, "KeyFigure","Name","Description") VALUES (101, 1, 'Sperrvermerk','Beschreibung');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoType" (id, "KeyFigure","Name","Description") VALUES (102, 2, 'Wegfallvermerk','Beschreibung');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoType" (id, "KeyFigure","Name","Description") VALUES (103, 3, 'Übertragbarkeitsvermerk','Beschreibung');
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoType" (id, "KeyFigure","Name","Description") VALUES (104, 4, 'Deckungsvermerk','Beschreibung');

-- BudgetMemoTemplate
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoTemplate" (id, "KeyFigure","Name","Text","AssignedBudgetMemoType.ID") VALUES (101, 1, 'Sperrvermerk','Die Ausgaben sind gesperrt.', 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoTemplate" (id, "KeyFigure","Name","Text","AssignedBudgetMemoType.ID") VALUES (102, 2, 'Sperrvermerk','Die Ausgaben i.H.v. [$Betrag$] sind gesperrt.', 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoTemplate" (id, "KeyFigure","Name","Text","AssignedBudgetMemoType.ID") VALUES (103, 3, 'Wegfallvermerk','Die Ausgaben fallen künftig weg.', 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoTemplate" (id, "KeyFigure","Name","Text","AssignedBudgetMemoType.ID") VALUES (104, 4, 'Wegfallvermerk','Die Ausgaben fallen am [$Datum$]/ mit Inbetriebnahme der [$Objekt$] weg.', 102);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoTemplate" (id, "KeyFigure","Name","Text","AssignedBudgetMemoType.ID") VALUES (105, 5, 'Wegfallvermerk','Ausgaben i.H.v. [$Betrag$] fallen am [$Datum$]/ mit Inbetriebnahme der [$Objekt$] weg', 102);

-- BudgetMemo
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemo" (id, "MemoOrder","Text","AssignedBudgetMemoType.ID","AssignedActivityGroup.ID","AssignedBudgetMemoTemplate.ID") VALUES (101, 1, 'Die Ausgaben sind gesperrt.', 101, 101, 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemo" (id, "MemoOrder","Text","AssignedBudgetMemoType.ID","AssignedActivityGroup.ID","AssignedBudgetMemoTemplate.ID") VALUES (102, 1, 'Die Ausgaben i.H.v. [$Betrag$] sind gesperrt.', 101, 102, 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemo" (id, "MemoOrder","Text","AssignedBudgetMemoType.ID","AssignedTitle.ID","AssignedBudgetMemoTemplate.ID") VALUES (103, 1, 'Die Ausgaben sind gesperrt', 101, 101, 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemo" (id, "MemoOrder","Text","AssignedBudgetMemoType.ID","AssignedTitle.ID","AssignedBudgetMemoTemplate.ID") VALUES (104, 1, 'Die Ausgaben i.H.v. [$Betrag$] sind gesperrt.', 101, 101, 102);

-- BudgetMemoVariable
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoVariable" (id, "TechnicalName","DisplayName","Value","AssignedBudgetMemo.ID") VALUES (101, 'Technical name1', 'DisplayName1', 'Value1', 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoVariable" (id, "TechnicalName","DisplayName","Value","AssignedBudgetMemo.ID") VALUES (102, 'Technical name2', 'DisplayName2', 'Value2', 101);
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetMemoVariable" (id, "TechnicalName","DisplayName","Value","AssignedBudgetMemo.ID") VALUES (103, 'Technical name3', 'DisplayName3', 'Value3', 101);

-- File
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.File" (id, "File", "Mime", "IsDeleted") VALUES (101, FILE_READ('src\\main\\resources\\file.svg'), 'file', false);

-- FileMatching
INSERT INTO "hkrbudgetingdb.db.dbmodel::hkrbudgeting.FileMatching" (id, "FileName", "Status", "IsDeleted", "AssignedTitle.ID","AssignedFile.ID") VALUES (101,'filename', 1, false, 101, 101);
