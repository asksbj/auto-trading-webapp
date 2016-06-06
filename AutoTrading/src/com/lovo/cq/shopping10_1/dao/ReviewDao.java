package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.User;
import com.lovo.cq.shopping10_1.po.Review;

public interface ReviewDao {
	public Review getReview(int userid, int dealerid, int carid);
	
	public boolean updateReview(int reviewer, int reviewee, int rate, String content, int carid);

}
