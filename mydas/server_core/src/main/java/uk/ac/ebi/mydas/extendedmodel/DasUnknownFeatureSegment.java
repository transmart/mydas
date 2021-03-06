package uk.ac.ebi.mydas.extendedmodel;

import java.util.Collection;

import uk.ac.ebi.mydas.controller.SegmentQuery;
import uk.ac.ebi.mydas.exceptions.DataSourceException;
import uk.ac.ebi.mydas.model.DasAnnotatedSegment;
import uk.ac.ebi.mydas.model.DasFeature;
import uk.ac.ebi.mydas.model.DasSequence;

@SuppressWarnings("serial")
public class DasUnknownFeatureSegment extends DasAnnotatedSegment {
	private SegmentQuery segmentQuery;
	public DasUnknownFeatureSegment(String segmentId, Integer startCoordinate,
			Integer stopCoordinate, String version, String segmentLabel,
			Collection<DasFeature> features) throws DataSourceException {
		super(segmentId, startCoordinate, stopCoordinate, version,
				segmentLabel, features);
	}

	public DasUnknownFeatureSegment(DasSequence sequence, String segmentLabel,
			Collection<DasFeature> features) throws DataSourceException {
		super(sequence, segmentLabel, features);
	}
	public DasUnknownFeatureSegment(String segmentId) throws DataSourceException{
		super(segmentId, 0, 0, "_", null, null);
	}
	public DasUnknownFeatureSegment(SegmentQuery segmentQuery) throws DataSourceException{
        this(segmentQuery.isEmpty()?
                "EMPTY":
                segmentQuery.getSegmentId(),segmentQuery.getStartCoordinate(), segmentQuery.getStopCoordinate(), "error", "error", null);
		this.segmentQuery=segmentQuery;
	}
	public SegmentQuery getSegmentQuery(){
		return segmentQuery;
	}

}
