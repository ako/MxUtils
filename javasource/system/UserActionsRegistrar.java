package system;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.mendix.core.actionmanagement.IActionRegistrator;

@Component(immediate = true)
public class UserActionsRegistrar
{
  @Reference
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(appcloudservices.actions.GenerateRandomPassword.class);
    registrator.registerUserAction(appcloudservices.actions.LogOutUser.class);
    registrator.registerUserAction(appcloudservices.actions.StartSignOnServlet.class);
    registrator.registerUserAction(communitycommons.actions.acquireLock.class);
    registrator.registerUserAction(communitycommons.actions.Base64Decode.class);
    registrator.registerUserAction(communitycommons.actions.Base64DecodeToFile.class);
    registrator.registerUserAction(communitycommons.actions.Base64Encode.class);
    registrator.registerUserAction(communitycommons.actions.Base64EncodeFile.class);
    registrator.registerUserAction(communitycommons.actions.Clone.class);
    registrator.registerUserAction(communitycommons.actions.commitInSeparateDatabaseTransaction.class);
    registrator.registerUserAction(communitycommons.actions.commitWithoutEvents.class);
    registrator.registerUserAction(communitycommons.actions.copyAttributes.class);
    registrator.registerUserAction(communitycommons.actions.DateTimeToLong.class);
    registrator.registerUserAction(communitycommons.actions.DecryptString.class);
    registrator.registerUserAction(communitycommons.actions.DeepClone.class);
    registrator.registerUserAction(communitycommons.actions.Delay.class);
    registrator.registerUserAction(communitycommons.actions.deleteAll.class);
    registrator.registerUserAction(communitycommons.actions.DuplicateFileDocument.class);
    registrator.registerUserAction(communitycommons.actions.DuplicateImageDocument.class);
    registrator.registerUserAction(communitycommons.actions.encryptMemberIfChanged.class);
    registrator.registerUserAction(communitycommons.actions.EncryptString.class);
    registrator.registerUserAction(communitycommons.actions.EndTransaction.class);
    registrator.registerUserAction(communitycommons.actions.EscapeHTML.class);
    registrator.registerUserAction(communitycommons.actions.executeMicroflowAsUser.class);
    registrator.registerUserAction(communitycommons.actions.executeMicroflowAsUser_1.class);
    registrator.registerUserAction(communitycommons.actions.executeMicroflowAsUser_2.class);
    registrator.registerUserAction(communitycommons.actions.executeMicroflowInBackground.class);
    registrator.registerUserAction(communitycommons.actions.executeMicroflowInBatches.class);
    registrator.registerUserAction(communitycommons.actions.FileDocumentFromFile.class);
    registrator.registerUserAction(communitycommons.actions.FileFromFileDocument.class);
    registrator.registerUserAction(communitycommons.actions.GenerateHMAC_SHA256_hash.class);
    registrator.registerUserAction(communitycommons.actions.GetApplicationUrl.class);
    registrator.registerUserAction(communitycommons.actions.getCreatedByUser.class);
    registrator.registerUserAction(communitycommons.actions.GetDefaultLanguage.class);
    registrator.registerUserAction(communitycommons.actions.GetFileContentsFromResource.class);
    registrator.registerUserAction(communitycommons.actions.getFileSize.class);
    registrator.registerUserAction(communitycommons.actions.getGUID.class);
    registrator.registerUserAction(communitycommons.actions.GetIntFromDateTime.class);
    registrator.registerUserAction(communitycommons.actions.getLastChangedByUser.class);
    registrator.registerUserAction(communitycommons.actions.getLockOwner.class);
    registrator.registerUserAction(communitycommons.actions.getOriginalValueAsString.class);
    registrator.registerUserAction(communitycommons.actions.GetRuntimeVersion.class);
    registrator.registerUserAction(communitycommons.actions.getTypeAsString.class);
    registrator.registerUserAction(communitycommons.actions.Hash.class);
    registrator.registerUserAction(communitycommons.actions.HTMLEncode.class);
    registrator.registerUserAction(communitycommons.actions.HTMLToPlainText.class);
    registrator.registerUserAction(communitycommons.actions.IsInDevelopment.class);
    registrator.registerUserAction(communitycommons.actions.Log.class);
    registrator.registerUserAction(communitycommons.actions.LongToDateTime.class);
    registrator.registerUserAction(communitycommons.actions.memberHasChanged.class);
    registrator.registerUserAction(communitycommons.actions.MergeMultiplePdfs.class);
    registrator.registerUserAction(communitycommons.actions.objectHasChanged.class);
    registrator.registerUserAction(communitycommons.actions.objectIsNew.class);
    registrator.registerUserAction(communitycommons.actions.OverlayPdfDocument.class);
    registrator.registerUserAction(communitycommons.actions.ParseDateTimeWithTimezone.class);
    registrator.registerUserAction(communitycommons.actions.RandomHash.class);
    registrator.registerUserAction(communitycommons.actions.RandomString.class);
    registrator.registerUserAction(communitycommons.actions.RandomStrongPassword.class);
    registrator.registerUserAction(communitycommons.actions.recommitInBatches.class);
    registrator.registerUserAction(communitycommons.actions.refreshClass.class);
    registrator.registerUserAction(communitycommons.actions.refreshClassByObject.class);
    registrator.registerUserAction(communitycommons.actions.RegexQuote.class);
    registrator.registerUserAction(communitycommons.actions.RegexReplaceAll.class);
    registrator.registerUserAction(communitycommons.actions.RegexTest.class);
    registrator.registerUserAction(communitycommons.actions.releaseAllInactiveLocks.class);
    registrator.registerUserAction(communitycommons.actions.releaseLock.class);
    registrator.registerUserAction(communitycommons.actions.retrieveURL.class);
    registrator.registerUserAction(communitycommons.actions.RunMicroflowAsyncInQueue.class);
    registrator.registerUserAction(communitycommons.actions.SimpleLog.class);
    registrator.registerUserAction(communitycommons.actions.StartTransaction.class);
    registrator.registerUserAction(communitycommons.actions.storeURLToFileDocument.class);
    registrator.registerUserAction(communitycommons.actions.StringFromFile.class);
    registrator.registerUserAction(communitycommons.actions.StringLeftPad.class);
    registrator.registerUserAction(communitycommons.actions.StringLength.class);
    registrator.registerUserAction(communitycommons.actions.StringRightPad.class);
    registrator.registerUserAction(communitycommons.actions.StringToFile.class);
    registrator.registerUserAction(communitycommons.actions.StringTrim.class);
    registrator.registerUserAction(communitycommons.actions.SubstituteTemplate.class);
    registrator.registerUserAction(communitycommons.actions.SubstituteTemplate2.class);
    registrator.registerUserAction(communitycommons.actions.ThrowException.class);
    registrator.registerUserAction(communitycommons.actions.ThrowWebserviceException.class);
    registrator.registerUserAction(communitycommons.actions.TimeMeasureEnd.class);
    registrator.registerUserAction(communitycommons.actions.TimeMeasureStart.class);
    registrator.registerUserAction(communitycommons.actions.waitForLock.class);
    registrator.registerUserAction(communitycommons.actions.XSSSanitize.class);
    registrator.registerUserAction(communitycommons.actions.YearsBetween.class);
    registrator.registerUserAction(mixpanel.actions.SendEvent.class);
    registrator.registerUserAction(mxawsrekognition.actions.DetectFaces.class);
    registrator.registerUserAction(mxawsrekognition.actions.GetLabelsForImage.class);
    registrator.registerUserAction(mxawsrekognition.actions.IndexFaces.class);
    registrator.registerUserAction(mxawss3.actions.S3CopyFileDocumentToBucket.class);
    registrator.registerUserAction(mxdatetime.actions.UnixEpochMillisToDateTime.class);
    registrator.registerUserAction(mxdatetime.actions.UnixEpochSecondsToDateTime.class);
    registrator.registerUserAction(mxgoogleanalytics.actions.GaTrackEvent.class);
    registrator.registerUserAction(mxgoogleanalytics.actions.GaTrackException.class);
    registrator.registerUserAction(mxgoogleanalytics.actions.GaTrackPageView.class);
    registrator.registerUserAction(mxlists.actions.GenerateDateTimeSeries.class);
    registrator.registerUserAction(mxlists.actions.GenerateLongSeries.class);
    registrator.registerUserAction(mxmustache.actions.FillTemplate.class);
    registrator.registerUserAction(mxmustache.actions.FillTemplateFromMappingToFileDocument.class);
    registrator.registerUserAction(mxmustache.actions.FillTemplateToFileDocument.class);
    registrator.registerUserAction(mxmustache.actions.SendEmail.class);
    registrator.registerUserAction(mxmustachetests.actions.StartSmtpMock.class);
    registrator.registerUserAction(mxnlp.actions.InitNetwork.class);
    registrator.registerUserAction(mxnlp.actions.Predict.class);
    registrator.registerUserAction(mxscripting.actions.ExecGroovy.class);
    registrator.registerUserAction(mxscripting.actions.ExecPython.class);
    registrator.registerUserAction(mxutils.actions.SetConfigFromProperty.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
    registrator.registerUserAction(unittesting.actions.FindAllUnitTests.class);
    registrator.registerUserAction(unittesting.actions.ReportStepJava.class);
    registrator.registerUserAction(unittesting.actions.RunAllUnitTestsWrapper.class);
    registrator.registerUserAction(unittesting.actions.RunUnitTest.class);
    registrator.registerUserAction(unittesting.actions.StartRemoteApiServlet.class);
    registrator.registerUserAction(unittesting.actions.StartRunAllSuites.class);
    registrator.registerUserAction(unittesting.actions.ThrowAssertionFailed.class);
  }
}
