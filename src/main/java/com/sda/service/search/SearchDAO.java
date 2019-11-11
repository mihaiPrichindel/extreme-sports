package com.sda.service.search;

import com.sda.dto.PlaceDTO;
import com.sda.hibernate_utils.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO implements ISearchDAO {

    private static Session session;


    public List findBest(String sportName, LocalDate startDate, LocalDate endDate) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> bestOffers = session.createQuery("select s.sportName, s.cost, p.placeName " +
                "from Place p " +
                "inner join Sport s on p.id = s.place " +
                "where s.sportName = :sportName and s.startDate >= :startDate and s.endDate <= :endDate " +
                "order by s.cost desc")
                .setParameter("sportName", sportName)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        session.close();
        // return list of PlaceDTO
        for (Object[] o : bestOffers) {
            String name = (String) o[0];
            Double sportPrice = (Double) o[1];
            String placeName = (String) o[2];

            PlaceDTO searchResult = new PlaceDTO(name, sportPrice, placeName);
            //   String theBestOffers = searchResult.toString();
            //   System.out.println(theBestOffers);

            List<PlaceDTO> dtoList = new ArrayList<>();
            dtoList.add(searchResult);
            dtoList.forEach(System.out::println);
        }
        return bestOffers;
    }

}
