package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.District;

@Repository
public interface DistrictRepository extends MongoRepository<District, ObjectId> {

        // query that returns all districts in a state
        public List<District> findByState(String state);

        // Aggregation for max value of a field
        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'total_population' : -1 }}",
                        "{$limit: 1}" })
        public District getTopTotalPopDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'hispanic_latino' : -1 }}",
                        "{$limit: 1}" })
        public District getTopLatinoDistrictIn(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'white' : -1 }}",
                        "{$limit: 1}" })
        public District getTopWhiteDistrictIn(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'black' : -1 }}",
                        "{$limit: 1}" })
        public District getTopBlackDistrictIn(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'american_indian_alaska_native' : -1 }}",
                        "{$limit: 1}" })
        public District getTopAlaskaDistrictIn(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'asian' : -1 }}",
                        "{$limit: 1}" })
        public District getTopAsianDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'hawaiian_pacific_islander' : -1 }}",
                        "{$limit: 1}" })
        public District getTopPacificDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'other' : -1 }}",
                        "{$limit: 1}" })
        public District getTopOtherDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'mixed' : -1 }}",
                        "{$limit: 1}" })
        public District getTopMixedDistrict(String state);

        /////////////// Aggregation for minimum value of a
        /////////////// field///////////////////////////
        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'total_population' : 1 }}",
                        "{$limit: 1}" })
        public District getMinTotalPopDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'white' : 1 }}",
                        "{$limit: 1}" })
        public District getMimWhiteDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'hispanic_latino' : 1 }}",
                        "{$limit: 1}" })
        public District getMinLatinoDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'black' : 1 }}",
                        "{$limit: 1}" })
        public District getMinBlackDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'american_indian_alaska_native' : 1 }}",
                        "{$limit: 1}" })
        public District getMinAlaskaDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'asian' : 1 }}",
                        "{$limit: 1}" })
        public District getMinAsianDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'hawaiian_pacific_islander' : 1 }}",
                        "{$limit: 1}" })
        public District getMinPacificDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'other' : 1 }}",
                        "{$limit: 1}" })
        public District getMinOtherDistrict(String state);

        @Aggregation(pipeline = { "{ $match: { 'state' : ?0 } }",
                        "{$sort: { 'mixed' : 1 }}",
                        "{$limit: 1}" })
        public District getMinMixedDistrict(String state);
}
