SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE "hkrbudgetingdb.db.dbmodel::hkrbudgeting.BudgetPlan";
TRUNCATE TABLE "hkrbudgetingdb.db.dbmodel::hkrbudgeting.NegotiationRound";
TRUNCATE TABLE "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Section";
TRUNCATE TABLE "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Chapter";
TRUNCATE TABLE "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Title";
TRUNCATE TABLE "hkrbudgetingdb.db.dbmodel::hkrbudgeting.Permission";

alter sequence "hkrbudgetingdb.db::S_BudgetPlan" restart with 1;
alter sequence "hkrbudgetingdb.db::S_NegotiationRound" restart with 1;
alter sequence "hkrbudgetingdb.db::S_Section" restart with 1;
alter sequence "hkrbudgetingdb.db::S_Chapter" restart with 1;
alter sequence "hkrbudgetingdb.db::S_Title" restart with 1;

SET FOREIGN_KEY_CHECKS=1;