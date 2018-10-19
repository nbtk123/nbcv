package com.nbtk.nbcv.base.data.repositories

import com.nbtk.nbcv.base.data.dao.Order
import com.nbtk.nbcv.base.data.dao.OrderBy
import com.nbtk.nbcv.base.data.db.Db
import java.lang.ref.WeakReference

class JobsRepository {
    private val dbRef: WeakReference<Db> = WeakReference(Db.instance)

    fun getAllJobs() = dbRef.get()?.jobDao()?.getAllJobs(OrderBy.START_DATE, Order.DESC)
}