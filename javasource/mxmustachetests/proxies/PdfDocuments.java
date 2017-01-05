// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package mxmustachetests.proxies;

public class PdfDocuments extends system.proxies.FileDocument
{
	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "MxMustacheTests.PdfDocuments";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		htmlSource("htmlSource"),
		FileID("FileID"),
		Name("Name"),
		DeleteAfterDownload("DeleteAfterDownload"),
		Contents("Contents"),
		HasContents("HasContents");

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

	public PdfDocuments(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "MxMustacheTests.PdfDocuments"));
	}

	protected PdfDocuments(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject pdfDocumentsMendixObject)
	{
		super(context, pdfDocumentsMendixObject);
		if (!com.mendix.core.Core.isSubClassOf("MxMustacheTests.PdfDocuments", pdfDocumentsMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a MxMustacheTests.PdfDocuments");
	}

	/**
	 * @deprecated Use 'PdfDocuments.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static mxmustachetests.proxies.PdfDocuments initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return mxmustachetests.proxies.PdfDocuments.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static mxmustachetests.proxies.PdfDocuments initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new mxmustachetests.proxies.PdfDocuments(context, mendixObject);
	}

	public static mxmustachetests.proxies.PdfDocuments load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return mxmustachetests.proxies.PdfDocuments.initialize(context, mendixObject);
	}

	public static java.util.List<mxmustachetests.proxies.PdfDocuments> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<mxmustachetests.proxies.PdfDocuments> result = new java.util.ArrayList<mxmustachetests.proxies.PdfDocuments>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//MxMustacheTests.PdfDocuments" + xpathConstraint))
			result.add(mxmustachetests.proxies.PdfDocuments.initialize(context, obj));
		return result;
	}

	/**
	 * @return value of htmlSource
	 */
	public final java.lang.String gethtmlSource()
	{
		return gethtmlSource(getContext());
	}

	/**
	 * @param context
	 * @return value of htmlSource
	 */
	public final java.lang.String gethtmlSource(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.htmlSource.toString());
	}

	/**
	 * Set value of htmlSource
	 * @param htmlsource
	 */
	public final void sethtmlSource(java.lang.String htmlsource)
	{
		sethtmlSource(getContext(), htmlsource);
	}

	/**
	 * Set value of htmlSource
	 * @param context
	 * @param htmlsource
	 */
	public final void sethtmlSource(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String htmlsource)
	{
		getMendixObject().setValue(context, MemberNames.htmlSource.toString(), htmlsource);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final mxmustachetests.proxies.PdfDocuments that = (mxmustachetests.proxies.PdfDocuments) obj;
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
		return "MxMustacheTests.PdfDocuments";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Override
	@Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
