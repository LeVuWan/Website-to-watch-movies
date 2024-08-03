package com.poly.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.poly.dao.abstractDAO;
import com.poly.dao.stafDAO;
import com.poly.dto.VideoLikedInfo;

public class stafDAOImpl extends abstractDAO<Object[]> implements stafDAO {

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		String sql = "select v.id, v.title, v.href, SUM(CAST(h.isLiked as int)) as totalLike "
				+ " from Videos v "
				+ " left join History h "
				+ " on v.id = h.videoId"
				+ " where v.isActive = 1 "
				+ " group by v.id, v.title, v.href "
				+ " order by SUM(CAST(h.isLiked as int)) desc";
		List<Object[]> objects = super.findManyByNativeQuery( sql);
		List<VideoLikedInfo> result = new ArrayList<VideoLikedInfo>();
		objects.forEach(object -> {
			VideoLikedInfo likedInfo = setDataVideoLikedInfo(object);
			result.add(likedInfo);
		});
		return result;
	}
	
	private VideoLikedInfo setDataVideoLikedInfo(Object[] object) {
		VideoLikedInfo likedInfo = new VideoLikedInfo();
		likedInfo.setId((Integer)object[0]);
		likedInfo.setTitle((String)object[1]);
		likedInfo.setHref((String) object[2]);
		likedInfo.setTotalLike(object[3]==null? 0 : (Integer)object[3]);
		return likedInfo;
	}

}
