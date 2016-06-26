// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package mxutils.proxies;

public class MultiSeriesChart
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject multiSeriesChartMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "MxUtils.MultiSeriesChart";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		CreationDate("CreationDate"),
		Name("Name"),
		MultiSeriesChart_MultiSeriesDataset("MxUtils.MultiSeriesChart_MultiSeriesDataset");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public MultiSeriesChart(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "MxUtils.MultiSeriesChart"));
	}

	protected MultiSeriesChart(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject multiSeriesChartMendixObject)
	{
		if (multiSeriesChartMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("MxUtils.MultiSeriesChart", multiSeriesChartMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a MxUtils.MultiSeriesChart");

		this.multiSeriesChartMendixObject = multiSeriesChartMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'MultiSeriesChart.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static mxutils.proxies.MultiSeriesChart initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return mxutils.proxies.MultiSeriesChart.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.getSudoContext() can be used to obtain sudo access).
	 */
	public static mxutils.proxies.MultiSeriesChart initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new mxutils.proxies.MultiSeriesChart(context, mendixObject);
	}

	public static mxutils.proxies.MultiSeriesChart load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return mxutils.proxies.MultiSeriesChart.initialize(context, mendixObject);
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of CreationDate
	 */
	public final java.util.Date getCreationDate()
	{
		return getCreationDate(getContext());
	}

	/**
	 * @param context
	 * @return value of CreationDate
	 */
	public final java.util.Date getCreationDate(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.CreationDate.toString());
	}

	/**
	 * Set value of CreationDate
	 * @param creationdate
	 */
	public final void setCreationDate(java.util.Date creationdate)
	{
		setCreationDate(getContext(), creationdate);
	}

	/**
	 * Set value of CreationDate
	 * @param context
	 * @param creationdate
	 */
	public final void setCreationDate(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date creationdate)
	{
		getMendixObject().setValue(context, MemberNames.CreationDate.toString(), creationdate);
	}

	/**
	 * @return value of Name
	 */
	public final String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @return value of MultiSeriesChart_MultiSeriesDataset
	 */
	public final java.util.List<mxutils.proxies.MultiSeriesDataset> getMultiSeriesChart_MultiSeriesDataset() throws com.mendix.core.CoreException
	{
		return getMultiSeriesChart_MultiSeriesDataset(getContext());
	}

	/**
	 * @param context
	 * @return value of MultiSeriesChart_MultiSeriesDataset
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<mxutils.proxies.MultiSeriesDataset> getMultiSeriesChart_MultiSeriesDataset(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<mxutils.proxies.MultiSeriesDataset> result = new java.util.ArrayList<mxutils.proxies.MultiSeriesDataset>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.MultiSeriesChart_MultiSeriesDataset.toString());
		if (valueObject == null)
			return result;
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject))
			result.add(mxutils.proxies.MultiSeriesDataset.initialize(context, mendixObject));
		return result;
	}

	/**
	 * Set value of MultiSeriesChart_MultiSeriesDataset
	 * @param multiserieschart_multiseriesdataset
	 */
	public final void setMultiSeriesChart_MultiSeriesDataset(java.util.List<mxutils.proxies.MultiSeriesDataset> multiserieschart_multiseriesdataset)
	{
		setMultiSeriesChart_MultiSeriesDataset(getContext(), multiserieschart_multiseriesdataset);
	}

	/**
	 * Set value of MultiSeriesChart_MultiSeriesDataset
	 * @param context
	 * @param multiserieschart_multiseriesdataset
	 */
	public final void setMultiSeriesChart_MultiSeriesDataset(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<mxutils.proxies.MultiSeriesDataset> multiserieschart_multiseriesdataset)
	{
		java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier> identifiers = new java.util.ArrayList<com.mendix.systemwideinterfaces.core.IMendixIdentifier>();
		for (mxutils.proxies.MultiSeriesDataset proxyObject : multiserieschart_multiseriesdataset)
			identifiers.add(proxyObject.getMendixObject().getId());
		getMendixObject().setValue(context, MemberNames.MultiSeriesChart_MultiSeriesDataset.toString(), identifiers);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return multiSeriesChartMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final mxutils.proxies.MultiSeriesChart that = (mxutils.proxies.MultiSeriesChart) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "MxUtils.MultiSeriesChart";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}