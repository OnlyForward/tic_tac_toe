package shibanov.tic_tac_toe.model;

import java.util.List;

import javax.inject.Inject;

import shibanov.tic_tac_toe.modelDb.DaoMaster;
import shibanov.tic_tac_toe.modelDb.DaoSession;
import shibanov.tic_tac_toe.modelDb.User;

public class DbHelper {

    private final DaoSession mDaoSession;


    @Inject
    public DbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    public List<User> getAllUsers(){
        return mDaoSession.getUserDao().loadAll();
    }

//    @Override
//    public List<Receipts> getAllReceipts() {
//        return mDaoSession.getReceiptsDao().loadAll();
//
//    }
//
//    @Override
//    public Boolean isReceiptsEmpty() {
//        return !(mDaoSession.getReceiptsDao().count() > 0);
//    }
//
//    @Override
//    public Long saveReceipts(final Receipts receipt) {
//        return mDaoSession.getReceiptsDao().insert(receipt);
//    }
//
//    @Override
//    public Boolean saveReceiptsList(final List<Receipts> receiptList) {
//        mDaoSession.getReceiptsDao().insertInTx(receiptList);
//        return true;
//    }
//
//    public Receipts getReceipt(Long Key) {
//        return mDaoSession.getReceiptsDao().load(Key);
//    }
//
//    public Boolean saveReceiptsSteps(ReceiptsSteps stepToReceipts) {
//        mDaoSession.getReceiptsStepsDao().insert(stepToReceipts);
//        return true;
//    }
//
//    public List<ReceiptsSteps> getReceiptsSteps(Long key) {
//        return mDaoSession.getReceiptsStepsDao()._queryReceipts_MListStep(key);
//    }
//
//    @Override
//    public Boolean saveReceiptsSteps(List<ReceiptsSteps> receiptsStepsList) {
//        mDaoSession.getReceiptsStepsDao().insertInTx(receiptsStepsList);
//        return true;
//    }
//
//    public void deleteReceipt(Receipts receipt, List<ReceiptsSteps> list) {
//        Long key = receipt.getId_receipts();
////        deletePicture(receipt.getIcon());
////        deletePicture(receipt.getImageMain());
//        mDaoSession.getReceiptsDao().deleteByKey(key);
////        mDaoSession.getStepToReceiptsDao().deleteInTx(list);
//        mDaoSession.getReceiptsStepsDao().deleteInTx(receipt.getMListStep());
//    }

}
